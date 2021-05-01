package com.vodafone.interview.senior.service;

import com.vodafone.interview.senior.dto.ParkCommand;

import java.util.List;


public interface ParkCommandProcessor {

    String giveTicket(String command);

    String processParkCommands(List<ParkCommand> parkCommandList);

}
