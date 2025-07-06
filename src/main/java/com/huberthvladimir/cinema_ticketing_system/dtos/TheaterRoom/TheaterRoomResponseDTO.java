package com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom;

import com.huberthvladimir.cinema_ticketing_system.entities.TheaterRoom;

public class TheaterRoomResponseDTO {

    private Long id;

    private String name;

    private String exhibitionType;

    public TheaterRoomResponseDTO() {}

    public TheaterRoomResponseDTO(Long id, String name, String exhibitionType) {
        this.id = id;
        this.name = name;
        this.exhibitionType = exhibitionType;
    }

    public TheaterRoomResponseDTO(TheaterRoom theaterRoom) {
        id = theaterRoom.getId();
        name = theaterRoom.getName();
        exhibitionType = theaterRoom.getExhibitionType();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExhibitionType() {
        return exhibitionType;
    }


}
