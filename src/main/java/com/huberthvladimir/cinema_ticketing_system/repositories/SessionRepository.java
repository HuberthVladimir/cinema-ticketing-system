package com.huberthvladimir.cinema_ticketing_system.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huberthvladimir.cinema_ticketing_system.entities.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, UUID> {

}
