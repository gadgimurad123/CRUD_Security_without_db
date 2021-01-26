package com.gaz.web.service;

import com.gaz.web.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public Map<String, User> getAllUsers();

    public void saveUser(User user);

    public User getUserByName(String name);

    public void deleteUser(String name);
}
