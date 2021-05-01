package com.vodafone.interview.junior.service.impl;

import com.vodafone.interview.junior.service.Car;
import org.springframework.stereotype.Service;


@Service
public class Cabrio implements Car {

    @Override
    public String getType() {
        return "Cabrio Car has produced.";
    }
}
