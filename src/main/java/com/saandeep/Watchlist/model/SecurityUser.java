package com.saandeep.Watchlist.model;

import com.saandeep.Watchlist.service.RolesService;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class SecurityUser implements UserDetails {
    @NonNull
    private final User user;
    @NonNull
    private final RolesService rolesService;


    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        // return user.getRolesList().stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).toList();
        return rolesService.getRolesOfUser(user.getId()).stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).toList();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
