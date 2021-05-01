package com.vodafone.interview.senior.mapper;

import com.vodafone.interview.senior.dto.CarDto;
import com.vodafone.interview.senior.entity.CarEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CarMapper {

    CarEntity dto2Entity(CarDto carDto);

    CarDto entity2Dto(CarEntity carDto);
}

