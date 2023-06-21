package com.saandeep.Watchlist.controller;

import com.saandeep.Watchlist.model.Roles;
import com.saandeep.Watchlist.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RolesController {
    @Autowired
    RolesService rolesService;
    @GetMapping("/user/{userId}")
    public List<Roles> getRolesOfUser(@PathVariable Long userId) {
        return rolesService.getRolesOfUser(userId);
    }

    @PostMapping("user/{userId}")
    public void createRoleForUser(@PathVariable Long userId, @RequestBody Roles role) {
        rolesService.createRoleForUser(userId, role);
    }

    @PutMapping("user/{userId}")
    public void updateRoleOfUser(@PathVariable Long userId, @RequestBody Roles role) {
        rolesService.updateRoleOfUser(userId,role);
    }

    @DeleteMapping("/{roleId}")
        public void deleteRoleOfUser(@PathVariable Long roleId) {
        rolesService.deleteRole(roleId);
    }
}
