package com.vodafone.interview.senior.service.impl;

import com.vodafone.interview.senior.dto.CarDto;
import com.vodafone.interview.senior.dto.ParkCommand;
import com.vodafone.interview.senior.entity.CarEntity;
import com.vodafone.interview.senior.enumeration.CommandTypeEnum;
import com.vodafone.interview.senior.mapper.CarMapper;
import com.vodafone.interview.senior.repository.CarRepository;
import com.vodafone.interview.senior.service.ParkCommandService;
import com.vodafone.interview.senior.util.ParkCommandUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ParkCommandServiceImpl implements ParkCommandService {

    @Value("${park.capacity}")
    private int parkCapacity;

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    private final Map<Integer, Boolean> slotMap = new HashMap<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private final static String GARAGE_IS_FULL_STR = "Garage is full.";

    @PostConstruct
    void init() {
        for (int i = 1; i <= parkCapacity; i++) {
            slotMap.put(i, false);
        }
    }

    @Override
    public String giveTicket(String command) {
        stringBuilder = new StringBuilder();
        List<ParkCommand> parkCommandList = ParkCommandUtil.generateParkCommandList(command);
        return processParkCommands(parkCommandList);
    }

    @Override
    public String processParkCommands(List<ParkCommand> parkCommandList) {
        for (ParkCommand parkCommand : parkCommandList) {
            if (parkCommand.getCommandType() == CommandTypeEnum.PARK) {
                Integer[] suitableParking = findSuitableParking(parkCommand.getCarDto());
                if (suitableParking != null) {
                    parkCommand.getCarDto().setParkSlotList(Arrays.asList(suitableParking));
                    carRepository.save(carMapper.dto2Entity(parkCommand.getCarDto()));
                    Arrays.asList(suitableParking).forEach(slotNumber -> slotMap.put(slotNumber, true));
                    stringBuilder.append("Allocated ").append(suitableParking.length).append(" slot.\n");
                } else {
                    stringBuilder.append(GARAGE_IS_FULL_STR).append("\n");
                }
            } else if (parkCommand.getCommandType() == CommandTypeEnum.LEAVE) {
                Optional<CarEntity> carEntityById = carRepository.getCarEntityById(parkCommand.getUniqueSequenceNumber());
                if (carEntityById.isPresent()) {
                    carRepository.delete(carEntityById.get());
                    leaveTheParkingSlot(carMapper.entity2Dto(carEntityById.get()));
                } else {
                    stringBuilder.append("There is no vehicle!");
                }
            } else if (parkCommand.getCommandType() == CommandTypeEnum.STATUS) {
                List<CarEntity> listOfCarsInTheGarage = carRepository.findAll();
                stringBuilder.append("\n\nStatus:\n");
                listOfCarsInTheGarage.forEach(car -> stringBuilder.append(car.getLicensePlate()).append(" ").append(car.getCarColor()).append(" ").append(car.getParkSlotList().toString()).append("\n"));
            }

        }
        return stringBuilder.toString();
    }

    private void leaveTheParkingSlot(CarDto carDto) {
        if (carDto == null) {
            throw new NullPointerException("carDto is null");
        }
        carDto.getParkSlotList().forEach(slotNumber -> slotMap.put(slotNumber, false));
    }

    private Integer[] findSuitableParking(CarDto carDto) {
        int slotSize = carDto.getCarType().getSlotSize();
        for (int i = 1; i <= parkCapacity; i++) {
            if (i == 1) {
                Integer[] suitableSlots = findSuitableForFirstSlots(slotSize);
                if (suitableSlots != null) {
                    return suitableSlots;
                }
            } else {
                Integer[] suitableSlots = findSuitableForFreeSlots(i, slotSize);
                if (suitableSlots != null) {
                    return suitableSlots;
                }
            }

        }
        return null;
    }

    private Integer[] findSuitableForFreeSlots(int index, int slotSize) {
        List<Integer> slotList = new ArrayList<>();
        for (int i = index - 1; i < index + slotSize; i++) {
            if (slotMap.containsKey(i) && !slotMap.get(i)) {
                slotList.add(i);
            } else {
                return null;
            }
        }
        slotList.remove(0);
        return slotList.toArray(new Integer[0]);
    }

    private Integer[] findSuitableForFirstSlots(int slotSize) {
        List<Integer> slotList = new ArrayList<>();
        for (int i = 1; i < slotSize + 1; i++) {
            if (slotMap.containsKey(i) && !slotMap.get(i)) {
                slotList.add(i);
            } else {
                return null;
            }
        }
        return slotList.toArray(new Integer[0]);
    }
}

