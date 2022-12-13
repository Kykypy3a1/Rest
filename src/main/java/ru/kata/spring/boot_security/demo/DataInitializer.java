package ru.kata.spring.boot_security.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //@PostConstruct
    //public void createTestAdmin() {
    //    if (userService.getAllUsers().isEmpty()) {
    //        User admin = new User("admin", "admin", 20);
    //        admin.setPassword(encoder.encode("100"));
    //        roleService.addRole(new Role(1,"ROLE_ADMIN"));
    //        roleService.addRole(new Role(2,"ROLE_USER"));
    //        userService.edit(admin,1, "ROLE_ADMIN");
    //    }
    //}
}
