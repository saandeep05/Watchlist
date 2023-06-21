package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.Roles;
import com.saandeep.Watchlist.model.User;
import com.saandeep.Watchlist.repository.RolesRepository;
import com.saandeep.Watchlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Roles> getRolesOfUser(Long userId) {
        return rolesRepository.findByUserId(userId);
    }

    @Override
    public void createRoleForUser(Long userId, Roles role) {
        if(userRepository.findById(userId).isPresent()) {
            User user = userRepository.findById(userId).get();
            role.setUser(user);
            rolesRepository.save(role);
        }
    }

    @Override
    public void updateRoleOfUser(Long userId, Roles role) {
        if(userRepository.findById(userId).stream().findFirst().isPresent()) {
            User user = userRepository.findById(userId).stream().findFirst().get();
            role.setUser(user);
            rolesRepository.save(role);
        }
    }

    @Override
    public void deleteRole(Long roleId) {
        rolesRepository.deleteById(roleId);
    }


}
