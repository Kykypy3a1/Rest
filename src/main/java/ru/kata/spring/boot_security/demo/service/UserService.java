package ru.kata.spring.boot_security.demo.service;



import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);

    @Transactional
    void editUser(User user);

    void removeUserById(Integer id);
    User getUserById(Integer id);
    User findByUsername(String username);
    List<Role> listRoles();

    void deleteById(Integer id);
}
