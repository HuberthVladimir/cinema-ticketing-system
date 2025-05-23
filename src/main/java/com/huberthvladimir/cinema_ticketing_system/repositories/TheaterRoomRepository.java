package com.huberthvladimir.cinema_ticketing_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huberthvladimir.cinema_ticketing_system.entities.TheaterRoom;

@Repository
public interface TheaterRoomRepository extends JpaRepository<TheaterRoom, Long> {

}
