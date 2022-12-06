package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
@Transactional(readOnly = false)
public class DataInitializor {
    private final UserService userService;

    @Autowired
    public DataInitializor(UserService userService) {
        this.userService = userService;
    }

    //Добавление пользователя для теста функционала
    @PostConstruct
    public void createTestAdmin() {
        if (userService.getAllUsers().isEmpty()) {
            User admin = new User("admin", "admin", 20, "$2a$12$LEw3I8C75TzmGXw1URpOZO7NMCGhMJDRmCRPflBzZNJjzzWmRh6N6");
            admin.setRoles(Set.of(new Role(1, "ROLE_ADMIN"), new Role(2, "ROLE_USER")));
            userService.saveUser(admin,"ROLE_ADMIN");
        }
    }
}
