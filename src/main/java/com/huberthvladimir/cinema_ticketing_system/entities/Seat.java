package com.huberthvladimir.cinema_ticketing_system.entities;

import com.huberthvladimir.cinema_ticketing_system.dtos.Seat.SeatRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char seatRow;

    private int seatNumber;

    private boolean isSpecialSeat;

    @ManyToOne
    @JoinColumn(name = "theater_room_id")
    private TheaterRoom theaterRoom;

    public Seat() {}

    public Seat(Long id, char seatRow, int seatNumber, boolean isSpecialSeat) {
        this.id = id;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.isSpecialSeat = isSpecialSeat;
    }

    public Seat(SeatRequestDTO dto, TheaterRoom theaterRoom) {
        this.seatRow = dto.getSeatRow();
        this.seatNumber = dto.getSeatNumber();
        this.isSpecialSeat = dto.isSpecialSeat();
        this.theaterRoom = theaterRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(char seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isSpecialSeat() {
        return isSpecialSeat;
    }

    public void setSpecialSeat(boolean isSpecialSeat) {
        this.isSpecialSeat = isSpecialSeat;
    }

    public TheaterRoom getTheaterRoom() {
        return theaterRoom;
    }

    public void seatTheaterRoom(TheaterRoom theaterRoom) {
        this.theaterRoom = theaterRoom;
    }

}
