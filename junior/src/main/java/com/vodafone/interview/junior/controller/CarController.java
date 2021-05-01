package com.vodafone.interview.junior.controller;

import com.vodafone.interview.junior.factory.CarFactory;
import com.vodafone.interview.junior.service.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {

    private final CarFactory carFactory;

    @Autowired
    public CarController(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @GetMapping("/getCarType")
    public String getCarType(@RequestParam String carType) {
        Car car = carFactory.getCar(carType);
        return car.getType();
    }

}
