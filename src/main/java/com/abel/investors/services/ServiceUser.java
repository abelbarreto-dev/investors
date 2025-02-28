package com.abel.investors.services;

import com.abel.investors.models.User;
import com.abel.investors.records.UserRecord;
import com.abel.investors.utilities.EmailUtility;
import com.abel.investors.utilities.PasswordUtility;
import com.abel.investors.utilities.UsernameUtility;
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
        UsernameUtility.checkUsername(user.username());
        EmailUtility.validateEmail(user.email());
        PasswordUtility.checkPassword(user.password(), 6);

        return null;
    }

    @Override
    public ResponseEntity<User> updateUser(UserRecord user) {
        if (user.email() != null) {
            UsernameUtility.checkUsername(user.email());
        }

        if (user.username() != null) {
            UsernameUtility.checkUsername(user.username());
        }

        if (user.password() != null) {
            PasswordUtility.checkPassword(user.password(), 6);
        }

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
    public ResponseEntity<User> getUserByEmailOrUsernameAndPassword(UserRecord user) {
        return null;
    }
}
