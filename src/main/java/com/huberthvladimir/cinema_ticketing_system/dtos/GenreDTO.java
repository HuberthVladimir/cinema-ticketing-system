package com.huberthvladimir.cinema_ticketing_system.dtos;

public class GenreDTO {

    private Long id;
    private String name;

    public GenreDTO() {}

    public GenreDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
