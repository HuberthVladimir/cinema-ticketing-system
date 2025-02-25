package com.huberthvladimir.cinema_ticketing_system.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huberthvladimir.cinema_ticketing_system.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
