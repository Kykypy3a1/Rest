package ru.kata.spring.boot_security.demo;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitializor {
    private final UserRepository userRepository;

    public DataInitializor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Добавление пользователя для теста функционала
    @PostConstruct
    public void createTestAdmin() {
        if (userRepository.findAll().isEmpty()) {
            User admin = new User("admin", "admin", 20, "$2a$12$LEw3I8C75TzmGXw1URpOZO7NMCGhMJDRmCRPflBzZNJjzzWmRh6N6");
            admin.setRoles(Set.of(new Role(1, "ROLE_ADMIN"), new Role(2, "ROLE_USER")));
            userRepository.save(admin);
        }
    }
}
