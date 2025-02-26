package com.abel.investors.services;

import com.abel.investors.models.User;
import com.abel.investors.records.UserRecord;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ServiceUser implements IServiceUser {
    @Override
    public ResponseEntity<User> createUser(UserRecord user) {
        return null;
    }

    @Override
    public ResponseEntity<User> updateUser(UserRecord user) {
        return null;
    }

    @Override
    public ResponseEntity<User> deleteUser(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserByID(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserByEmailAndPassword(UserRecord user) {
        return null;
    }
}
