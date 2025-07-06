package com.huberthvladimir.cinema_ticketing_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom.TheaterRoomResponseDTO;
import com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom.TheaterRoomRequestDTO;
import com.huberthvladimir.cinema_ticketing_system.entities.TheaterRoom;
import com.huberthvladimir.cinema_ticketing_system.repositories.TheaterRoomRepository;

@Service
public class TheaterRoomService {

    @Autowired
    TheaterRoomRepository theaterRoomRepository;

    // public TheaterRoomResponseDTO getAllTheaterRoom() {
    // TheaterRoom theaterRoom = theaterRoomRepository.

    // return new TheaterRoomResponseDTO(theaterRoom);
    // }

    public TheaterRoomResponseDTO getTheaterRoom(Long id) {
        TheaterRoom theaterRoom = theaterRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater room not found"));

        return new TheaterRoomResponseDTO(theaterRoom);
    }

    public TheaterRoomResponseDTO createTheaterRoom(TheaterRoomRequestDTO theaterRoomDTO) {
        TheaterRoom theaterRoom = new TheaterRoom(theaterRoomDTO);
        theaterRoom = theaterRoomRepository.save(theaterRoom);
        return new TheaterRoomResponseDTO(theaterRoom);
    }
}
