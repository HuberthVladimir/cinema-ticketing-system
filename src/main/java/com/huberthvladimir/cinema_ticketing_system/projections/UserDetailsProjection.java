package com.huberthvladimir.cinema_ticketing_system.projections;

public interface UserDetailsProjection {
    String getEmail();

    String getPassword();

    Long getRoleId();

    String getAuthority();
}
