package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.Roles;
import com.saandeep.Watchlist.model.User;
import com.saandeep.Watchlist.repository.RolesRepository;
import com.saandeep.Watchlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    PasswordEncoder bCrypt;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        userRepository.save(user);
        Roles role = new Roles(user, "ROLE_USER");
        rolesRepository.save(role);
    }

    @Override
    public void updateUser(Long id, User user) {
        if(userRepository.existsById(id)) {
            user.setId(id);
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public List<User> searchUser(String keyword) {
        return userRepository.findByUsernameContaining(keyword);
    }

}
