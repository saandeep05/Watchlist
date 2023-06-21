package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.SecurityUser;
import com.saandeep.Watchlist.model.User;
import com.saandeep.Watchlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesService rolesService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(user -> new SecurityUser(user, rolesService))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
