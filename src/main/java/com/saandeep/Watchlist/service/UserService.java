package com.saandeep.Watchlist.service;

import com.saandeep.Watchlist.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void createUser(User user);
    public void updateUser(Long id, User user);
    public void deleteUser(Long id);
    public List<User> searchUser(String keyword);
}
