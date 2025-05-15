package com.huberthvladimir.cinema_ticketing_system.dtos.Seat;

import com.huberthvladimir.cinema_ticketing_system.entities.Seat;
import com.huberthvladimir.cinema_ticketing_system.entities.TheaterRoom;
import com.huberthvladimir.cinema_ticketing_system.projections.GetAllSeatsProjection;

public class SeatResponseDTO {

    private Long id;

    private char seatRow;

    private int seatNumber;

    private boolean isSpecialSeat;

    private TheaterRoom theaterRoom;

    public SeatResponseDTO() {}

    public SeatResponseDTO(Seat seat, TheaterRoom theaterRoom) {
        this.id = seat.getId();
        this.seatRow = seat.getSeatRow();
        this.seatNumber = seat.getSeatNumber();
        this.isSpecialSeat = seat.isSpecialSeat();
        this.theaterRoom = theaterRoom;
    }

    public SeatResponseDTO(GetAllSeatsProjection projection) {
        this.id = projection.getSeatId();
        this.seatRow = projection.getSeatRow();
        this.seatNumber = projection.getSeatNumber();
        this.isSpecialSeat = projection.getIsSpecialSeat();
        this.theaterRoom = new TheaterRoom(projection);;
    }

    public Long getId() {
        return id;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isSpecialSeat() {
        return isSpecialSeat;
    }

    public TheaterRoom getTheaterRoom() {
        return theaterRoom;
    }

}
