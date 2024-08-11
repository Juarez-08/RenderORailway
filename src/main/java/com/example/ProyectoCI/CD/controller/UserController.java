package com.example.ProyectoCI.CD.controller;

import com.example.ProyectoCI.CD.model.User;
import com.example.ProyectoCI.CD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/users")
    public class UserController {
    @Autowired
    private  UserService userService;

        @PostMapping("/")
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }

        @GetMapping("/{userId}")
        public ResponseEntity<User> getUserById(@PathVariable String userId) {
            User user = userService.getUserById(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/")
        public ResponseEntity<List<User>> getAllUsers() {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        }

        @PutMapping("/{userId}")
        public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
            User updatedUser = userService.updateUser(userId, user);
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{userId}")
        public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        }
    }

