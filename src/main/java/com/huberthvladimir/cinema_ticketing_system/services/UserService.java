package com.huberthvladimir.cinema_ticketing_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huberthvladimir.cinema_ticketing_system.entities.Role;
import com.huberthvladimir.cinema_ticketing_system.entities.User;
import com.huberthvladimir.cinema_ticketing_system.projections.UserDetailsProjection;
import com.huberthvladimir.cinema_ticketing_system.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var result = userRepository.searchUserAndRolesByEmail(username);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection projection : result) {
            user.addRoles(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }
}
