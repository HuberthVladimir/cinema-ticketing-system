package com.huberthvladimir.cinema_ticketing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom.TheatherRoomRequestDTO;
import com.huberthvladimir.cinema_ticketing_system.services.TheaterRoomService;

@RestController
@RequestMapping(value = "/theather-rooms")
public class TheatherRoomController {

    @Autowired
    private TheaterRoomService theaterRoomService;

    @PostMapping
    public Object createTheaterRoom(@RequestBody TheatherRoomRequestDTO dto) {
        var newTheatherRoom = theaterRoomService.createTheaterRoom(dto);

        return newTheatherRoom;
    }

}
