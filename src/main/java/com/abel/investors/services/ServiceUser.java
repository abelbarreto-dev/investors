package com.abel.investors.services;

import com.abel.investors.exceptions.UserNotFoundException;
import com.abel.investors.models.User;
import com.abel.investors.records.UserRecord;
import com.abel.investors.repositories.UserRepository;
import com.abel.investors.utilities.EmailUtility;
import com.abel.investors.utilities.PasswordUtility;
import com.abel.investors.utilities.UsernameUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceUser implements IServiceUser {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<User> createUser(UserRecord user) {
        UsernameUtility.checkUsername(user.username());
        EmailUtility.validateEmail(user.email());
        PasswordUtility.checkPassword(user.password(), 6);

        User newUser = this.parseUserRecordToUser(user);

        User savedUser = this.userRepository.save(newUser);

        return ResponseEntity.ok(savedUser);
    }

    @Override
    public ResponseEntity<User> updateUser(UserRecord user) {
        User userToUpdate = this.userRepository.findByEmailOrUsername(user.email(), user.username());

        if (userToUpdate == null) {
            throw new UserNotFoundException("No User found with email or username");
        }

        if (user.email() != null) {
            UsernameUtility.checkUsername(user.email());
            userToUpdate.setEmail(user.email());
        }

        if (user.username() != null) {
            UsernameUtility.checkUsername(user.username());
            userToUpdate.setUsername(user.username());
        }

        if (user.password() != null) {
            PasswordUtility.checkPassword(user.password(), 6);
            userToUpdate.setPassword(user.password());
        }

        User userUpdated = this.userRepository.save(userToUpdate);
        return ResponseEntity.ok(userUpdated);
    }

    @Override
    public ResponseEntity<User> deleteUser(UUID id) {
        User user = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        this.userRepository.delete(user);

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> getUserByID(UUID id) {
        User user = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> getUserByEmailOrUsernameAndPassword(UserRecord user) {
        User loginUser = this.userRepository.findByUsernameAndPassword(user.username(), user.password());

        if (loginUser == null) {
            throw new UserNotFoundException("No User found with this username and password");
        }

        return ResponseEntity.ok(loginUser);
    }

    protected User parseUserRecordToUser(UserRecord userRecord) {
        User user = new User();

        user.setUsername(userRecord.username());
        user.setEmail(userRecord.email());
        user.setPassword(userRecord.password());

        return user;
    }
}
