package com.huberthvladimir.cinema_ticketing_system.dtos.Seat;

public class SeatRequestDTO {

    private char seatRow;

    private int seatNumber;

    private boolean isSpecialSeat;

    private Long theaterRoom;

    public SeatRequestDTO() {}

    public SeatRequestDTO(char seatRow, int seatNumber, boolean isSpecialSeat) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.isSpecialSeat = isSpecialSeat;
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

    public Long getTheaterRoom() {
        return theaterRoom;
    }

}
