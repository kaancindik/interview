package com.vodafone.interview.senior.controller;

import com.vodafone.interview.senior.service.ParkCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GarageController {

    private final ParkCommandService parkCommandService;

    @PostMapping("/processParking")
    public String processParking(@RequestBody String parkingCommands) {
        return parkCommandService.giveTicket(parkingCommands);
    }
}

