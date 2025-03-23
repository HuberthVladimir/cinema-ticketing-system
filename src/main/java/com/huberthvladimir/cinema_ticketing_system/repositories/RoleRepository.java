package com.huberthvladimir.cinema_ticketing_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huberthvladimir.cinema_ticketing_system.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
