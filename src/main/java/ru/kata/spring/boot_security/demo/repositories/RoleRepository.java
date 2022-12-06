package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

public interface RoleRepository {

    void save(Role role);

    Role findByRolename(String name);

    Set<Role> findAll();
}
