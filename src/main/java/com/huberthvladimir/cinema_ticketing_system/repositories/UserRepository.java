package com.huberthvladimir.cinema_ticketing_system.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huberthvladimir.cinema_ticketing_system.entities.User;
import com.huberthvladimir.cinema_ticketing_system.projections.UserDetailsProjection;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(nativeQuery = true, value = """
                SELECT TB_USERS.ID,TB_USERS.NAME,TB_USERS.EMAIL, TB_ROLES.AUTHORITY
                FROM TB_USERS
                INNER
                JOIN TB_USERS_ROLES ON TB_USERS_ROLES.USER_ID = TB_USERS.ID INNER
                JOIN TB_ROLES ON TB_ROLES.ID = TB_USERS_ROLES.ROLE_ID WHERE EMAIL=:email
            """)
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
}
