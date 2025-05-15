package com.huberthvladimir.cinema_ticketing_system.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huberthvladimir.cinema_ticketing_system.dtos.Seat.SeatRequestDTO;
import com.huberthvladimir.cinema_ticketing_system.dtos.Seat.SeatResponseDTO;
import com.huberthvladimir.cinema_ticketing_system.entities.Seat;
import com.huberthvladimir.cinema_ticketing_system.entities.TheaterRoom;
import com.huberthvladimir.cinema_ticketing_system.projections.GetAllSeatsProjection;
import com.huberthvladimir.cinema_ticketing_system.repositories.SeatRepository;
import com.huberthvladimir.cinema_ticketing_system.repositories.TheaterRoomRepository;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    TheaterRoomRepository theaterRoomRepository;

    public List<SeatResponseDTO> getAllSeats() {
        List<SeatResponseDTO> seatList = new ArrayList<>();
        List<GetAllSeatsProjection> seatListProjection = seatRepository.searchAllSeats();

        for (GetAllSeatsProjection seat : seatListProjection) {
            SeatResponseDTO reponseDTO = new SeatResponseDTO(seat);
            seatList.add(reponseDTO);
        }
        return seatList;
    }

    public SeatResponseDTO getSeatsById(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        TheaterRoom theaterRoom = theaterRoomRepository.findById(seat.getTheaterRoom().getId())
                .orElseThrow(() -> new RuntimeException("Theater room not found"));
        return new SeatResponseDTO(seat, theaterRoom);
    }

    public List<SeatResponseDTO> getSeatsByTheaterRoomId(Long theaterRoomId) {
        List<SeatResponseDTO> seatList = new ArrayList<>();
        List<GetAllSeatsProjection> seatListProjection =
                seatRepository.searchByTheaterRoomId(theaterRoomId);

        if (seatListProjection.isEmpty()) {
            return null;
        }

        for (GetAllSeatsProjection seat : seatListProjection) {
            SeatResponseDTO reponseDTO = new SeatResponseDTO(seat);
            seatList.add(reponseDTO);
        }

        return seatList;
    }

    public SeatResponseDTO addSeat(SeatRequestDTO dto) {

        TheaterRoom theaterRoom = theaterRoomRepository.findById(dto.getTheaterRoom())
                .orElseThrow(() -> new RuntimeException("Theater room not found"));

        Seat seat = new Seat(dto, theaterRoom);

        Boolean seatAlreadyExist = seatRepository.searchSeatIfExists(seat.getSeatRow(),
                seat.getSeatNumber(), seat.getTheaterRoom().getId());

        if (seatAlreadyExist) {
            // throw new SeatAlreadyExistsException();
        }

        seat = seatRepository.save(seat);
        return new SeatResponseDTO(seat, theaterRoom);
    }

    public SeatResponseDTO updateSeat(Long seatId, SeatRequestDTO dto) {

        Seat existingSeat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        Boolean seatAlreadyExist = seatRepository.searchSeatIfExists(dto.getSeatRow(),
                dto.getSeatNumber(), dto.getTheaterRoom());

        if (seatAlreadyExist) {
            // throw new SeatAlreadyExistsException();
        }

        TheaterRoom theaterRoom = theaterRoomRepository.findById(dto.getTheaterRoom())
                .orElseThrow(() -> new RuntimeException("Theater room not found"));

        existingSeat.setSeatRow(dto.getSeatRow());
        existingSeat.setSeatNumber(dto.getSeatNumber());
        existingSeat.seatTheaterRoom(theaterRoom);

        Seat updatedSeat = seatRepository.save(existingSeat);

        return new SeatResponseDTO(updatedSeat, theaterRoom);
    }

    public void deleteSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        seatRepository.delete(seat);
    }
}
