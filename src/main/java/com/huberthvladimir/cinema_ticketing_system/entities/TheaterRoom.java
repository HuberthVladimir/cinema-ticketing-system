package com.huberthvladimir.cinema_ticketing_system.entities;

import java.util.ArrayList;
import java.util.List;

import com.huberthvladimir.cinema_ticketing_system.dtos.TheaterRoom.TheaterRoomRequestDTO;
import com.huberthvladimir.cinema_ticketing_system.projections.GetAllSeatsProjection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_theater_rooms")
public class TheaterRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int capacity;

    private String exhibitionType;

    @OneToMany(mappedBy = "theaterRoom")
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "theaterRoom")
    private List<Session> sessions = new ArrayList<>();

    public TheaterRoom() {}

    public TheaterRoom(Long id, int capacity, String name, String exhibitionType) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
        this.exhibitionType = exhibitionType;
    }

    public TheaterRoom(TheaterRoomRequestDTO requestDTO) {
        this.name = requestDTO.getName();
        this.exhibitionType = requestDTO.getExhibitionType();
    }

    public TheaterRoom(GetAllSeatsProjection projection) {
        this.id = projection.getTheaterRoomId();
        this.name = projection.getTheaterRoomName();
        this.capacity = projection.getCapacity();
        this.exhibitionType = projection.getExhibitionType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExhibitionType() {
        return exhibitionType;
    }

    public void setExhibitionType(String exhibitionType) {
        this.exhibitionType = exhibitionType;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Seat seats) {
        this.seats.add(seats);
    }

    public List<Session> getSession() {
        return sessions;
    }
}
