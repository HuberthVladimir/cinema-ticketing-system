package com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom;

public class TheaterRoomRequestDTO {

    private String name;

    private String exhibitionType;

    public TheaterRoomRequestDTO() {}

    public TheaterRoomRequestDTO(String name, String exhibitionType) {
        this.name = name;
        this.exhibitionType = exhibitionType;
    }

    public String getName() {
        return name;
    }

    public String getExhibitionType() {
        return exhibitionType;
    }


}
