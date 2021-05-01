package com.vodafone.interview.senior.dto;

import com.vodafone.interview.senior.enumeration.CommandTypeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


@Data
@Builder
public class ParkCommand {

    @NonNull
    private CommandTypeEnum commandType;
    private CarDto carDto;
    private Integer uniqueSequenceNumber;

}
