package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.Roles;

import java.util.List;

public interface RolesService {
    public List<Roles> getRolesOfUser(Long userId);
    public void createRoleForUser(Long userId, Roles role);
    public void updateRoleOfUser(Long userId, Roles role);
    public void deleteRole(Long roleId);
}
