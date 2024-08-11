package com.example.ProyectoCI.CD.service;

import java.util.List;
import com.example.ProyectoCI.CD.model.User;

public interface UserService {

    User createUser(User user);

    User getUserById(String userId);

    List<User> getAllUsers();

    User updateUser(String userId, User user);

    void deleteUser(String userId);
}
