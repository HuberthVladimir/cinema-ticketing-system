package com.huberthvladimir.cinema_ticketing_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom.TheatherRoomRequestDTO;
import com.huberthvladimir.cinema_ticketing_system.entities.TheaterRoom;
import com.huberthvladimir.cinema_ticketing_system.repositories.TheaterRoomRepository;

@Service
public class TheaterRoomService {

    @Autowired
    TheaterRoomRepository theaterRoomRepository;

    public TheaterRoom createTheaterRoom(TheatherRoomRequestDTO theaterRoomDTO) {
        // public TheaterRoomResponseDTO createTheaterRoom(TheatherRoomRequestDTO theaterRoomDTO) {

        TheaterRoom theaterRoom = new TheaterRoom(theaterRoomDTO);
        theaterRoom = theaterRoomRepository.save(theaterRoom);
        return theaterRoom;
        // return new TheaterRoomResponseDTO(t);
    }
}
