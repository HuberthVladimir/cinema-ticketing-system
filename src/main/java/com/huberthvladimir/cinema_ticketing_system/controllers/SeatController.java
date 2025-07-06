package com.huberthvladimir.cinema_ticketing_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huberthvladimir.cinema_ticketing_system.dtos.Seat.SeatRequestDTO;
import com.huberthvladimir.cinema_ticketing_system.dtos.Seat.SeatResponseDTO;
import com.huberthvladimir.cinema_ticketing_system.services.SeatService;

@RestController
@RequestMapping(value = "/seats")
public class SeatController {

    @Autowired
    SeatService seatService;

    @GetMapping
    public List<SeatResponseDTO> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public SeatResponseDTO getSeatById(@PathVariable Long id) {
        return seatService.getSeatsById(id);
    }

    @GetMapping("/theater-room/{theaterRoomId}")
    public List<SeatResponseDTO> getSeatByTheaterRoomId(@PathVariable Long id) {
        return seatService.getSeatsByTheaterRoomId(id);
    }

    @PostMapping
    public SeatResponseDTO createSeat(@RequestBody SeatRequestDTO dto) {
        var seat = seatService.addSeat(dto);
        return seat;
    }

    @PutMapping("/{id}")
    public SeatResponseDTO updateSeat(@PathVariable Long id, @RequestBody SeatRequestDTO dto) {
        var entity = seatService.updateSeat(id, dto);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
    }

}
