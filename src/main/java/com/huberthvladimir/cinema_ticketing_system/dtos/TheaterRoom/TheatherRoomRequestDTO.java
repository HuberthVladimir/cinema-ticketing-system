package com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom;

public class TheatherRoomRequestDTO {

    private String name;

    private String exibithionType;

    public TheatherRoomRequestDTO() {}

    public TheatherRoomRequestDTO(String name, String exibithionType) {
        this.name = name;
        this.exibithionType = exibithionType;
    }

    public String getName() {
        return name;
    }

    public String getExibithionType() {
        return exibithionType;
    }


}
