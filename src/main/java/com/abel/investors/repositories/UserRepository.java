package com.abel.investors.repositories;

import com.abel.investors.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmailOrUsername(String email, String email1);

    User findByUsernameAndPassword(String username, String password);
}
