package com.vodafone.interview.junior.factory;

import com.vodafone.interview.junior.service.Car;
import com.vodafone.interview.junior.service.impl.Cabrio;
import com.vodafone.interview.junior.service.impl.Hatchback;
import com.vodafone.interview.junior.service.impl.Sedan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CarFactory {

    private final Sedan sedan;
    private final Hatchback hatchback;
    private final Cabrio cabrio;

    @Autowired
    public CarFactory(Sedan sedan, Hatchback hatchback, Cabrio cabrio) {
        this.sedan = sedan;
        this.hatchback = hatchback;
        this.cabrio = cabrio;
    }

    public Car getCar(String carType) {
        if (carType == null) {
            return null;
        }
        carType = carType.toLowerCase();

        switch (carType) {
            case "cabrio":
                return cabrio;
            case "sedan":
                return sedan;
            case "hatchback":
                return hatchback;
            default:
                return null;
        }
    }
}