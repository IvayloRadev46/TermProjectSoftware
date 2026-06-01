package org.example.services;

import org.example.models.User;
import org.example.repo.UserRepo;

public class LoginService {

    private final UserRepo userRepo = new UserRepo();

    public String login(String email, String password) {
        if (email == null || email.isBlank()) {
            return "Имейлът е задължителен";
        }

        if (password == null || password.isBlank()) {
            return "Паролата е задължителна";
        }

        User user = userRepo.findByEmail(email);

        if (user == null) {
            return "Потребителят не съществува";
        }

        if (!user.getPassword().equals(password)) {
            return "Грешна парола";
        }

        return "Успешен вход";
    }
}