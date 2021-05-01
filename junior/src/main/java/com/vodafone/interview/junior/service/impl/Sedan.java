package com.vodafone.interview.junior.service.impl;

import com.vodafone.interview.junior.service.Car;
import org.springframework.stereotype.Service;


@Service
public class Sedan implements Car {

    @Override
    public String getType() {
        return "Sedan Car has produced.";
    }
}
