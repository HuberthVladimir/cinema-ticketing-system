package com.huberthvladimir.cinema_ticketing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom.TheaterRoomRequestDTO;
import com.huberthvladimir.cinema_ticketing_system.services.TheaterRoomService;

@RestController
@RequestMapping(value = "/theater-rooms")
public class TheaterRoomController {

    @Autowired
    private TheaterRoomService theaterRoomService;

    @PostMapping
    public Object createTheaterRoom(@RequestBody TheaterRoomRequestDTO dto) {
        return theaterRoomService.createTheaterRoom(dto);
    }

}
