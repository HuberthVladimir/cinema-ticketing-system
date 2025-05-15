package com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom;

public class TheaterRoomResponseDTO {

    private Long id;

    private String name;

    private String exibithionType;

    public TheaterRoomResponseDTO() {}

    public TheaterRoomResponseDTO(Long id, String name, String exibithionType) {
        this.id = id;
        this.name = name;
        this.exibithionType = exibithionType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExibithionType() {
        return exibithionType;
    }


}
