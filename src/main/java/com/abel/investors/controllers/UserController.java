package com.abel.investors.controllers;

import com.abel.investors.models.User;
import com.abel.investors.records.UserRecord;
import com.abel.investors.services.IServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final IServiceUser serviceUser;

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody UserRecord user) {
        return serviceUser.createUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserRecord user) {
        return serviceUser.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable UUID id) {
        return serviceUser.deleteUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable UUID id) {
        return serviceUser.getUserByID(id);
    }

    @PostMapping("/login")
    public ResponseEntity<User> getUserByEmailOrUsernameAndPassword(@RequestBody UserRecord user) {
        return serviceUser.getUserByEmailOrUsernameAndPassword(user);
    }
}
