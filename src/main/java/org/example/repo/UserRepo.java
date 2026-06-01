package org.example.repo;

import org.example.models.User;
import org.example.util.Database;

public class UserRepo {

    public User findByEmail(String email) {
        for (User user : Database.users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }
}