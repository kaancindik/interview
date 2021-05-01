package com.vodafone.interview.senior.util;

import com.vodafone.interview.senior.dto.CarDto;
import com.vodafone.interview.senior.dto.ParkCommand;
import com.vodafone.interview.senior.enumeration.CarTypeEnum;
import com.vodafone.interview.senior.enumeration.CommandTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class ParkCommandUtil {

    public static List<ParkCommand> generateParkCommandList(String multiCommand) {
        List<ParkCommand> parkCommandList = new ArrayList<>();
        String[] split = multiCommand.split("\n");
        for (String value : split) {
            if (!value.equals("")) {
                value = value.replace("\r","");
                String[] s = value.split(" ");
                ParkCommand parkCommand = null;
                if (s.length == 4) {
                    CarDto carDto = new CarDto(null, s[1], s[2], CarTypeEnum.fromString(s[3]), null);
                    parkCommand = ParkCommand.builder()
                            .commandType(CommandTypeEnum.PARK)
                            .carDto(carDto)
                            .build();
                } else if (s.length == 2) {
                    parkCommand = ParkCommand.builder()
                            .commandType(CommandTypeEnum.LEAVE)
                            .uniqueSequenceNumber(Integer.valueOf(s[1]))
                            .build();

                } else if (s.length == 1) {
                    parkCommand = ParkCommand.builder()
                            .commandType(CommandTypeEnum.STATUS)
                            .build();

                }
                parkCommandList.add(parkCommand);
            }
        }
        return parkCommandList;
    }
}

