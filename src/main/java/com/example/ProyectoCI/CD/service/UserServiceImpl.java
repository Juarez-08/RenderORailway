package com.example.ProyectoCI.CD.service;

import com.example.ProyectoCI.CD.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    // Simulación de base de datos en memoria con HashMap
    private  Map<String, User> userMap = new HashMap<>();

    @Override
    public User createUser(User user) {
        // Generar un ID único (puede ser un UUID aleatorio en una implementación real)
        String userId = String.valueOf(userMap.size() + 1);
        user.setId(userId);
        userMap.put(userId, user);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        return userMap.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User updateUser(String userId, User user) {
        if (userMap.containsKey(userId)) {
            user.setId(userId); // Asegurar que el ID del usuario sea el mismo que el ID proporcionado
            userMap.put(userId, user);
            return user;
        }
        return null; // O manejar el caso de usuario no encontrado, lanzar excepción, etc.
    }

    @Override
    public void deleteUser(String userId) {
        userMap.remove(userId);
    }
}