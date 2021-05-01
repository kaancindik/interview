package com.vodafone.interview.senior.dto;

import com.vodafone.interview.senior.enumeration.CarTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class CarDto {

    private Integer id;
    private String licensePlate;
    private String carColor;
    private CarTypeEnum carType;
    private List<Integer> parkSlotList;
}
