package com.huberthvladimir.cinema_ticketing_system.projections;

import java.util.UUID;

public interface UserDetailsProjection {
    UUID getId();

    String getName();

    String getEmail();

    String getAuthority();
}
