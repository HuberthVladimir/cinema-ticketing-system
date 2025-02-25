package com.huberthvladimir.cinema_ticketing_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huberthvladimir.cinema_ticketing_system.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
