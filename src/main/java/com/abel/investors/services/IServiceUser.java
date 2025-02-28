package com.abel.investors.services;

import com.abel.investors.models.User;
import com.abel.investors.records.UserRecord;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IServiceUser {
    public ResponseEntity<User> createUser(UserRecord user);
    public ResponseEntity<User> updateUser(UserRecord user);
    public ResponseEntity<User> deleteUser(UUID id);
    public ResponseEntity<User> getUserByID(UUID id);
    public ResponseEntity<User> getUserByEmailOrUsernameAndPassword(UserRecord user);
}
