package com.huberthvladimir.cinema_ticketing_system.projections;

public interface GetAllSeatsProjection {

    Long getSeatId();

    int getSeatNumber();

    char getSeatRow();

    Boolean getIsSpecialSeat();

    Long getTheaterRoomId();

    String getTheaterRoomName();

    int getCapacity();

    String getExibithionType();
}
