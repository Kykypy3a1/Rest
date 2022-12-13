package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleRepositoryImpl implements RoleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role findByRolename(String name) {
        return entityManager.find(Role.class, name);
    }

    @Override
    public Set<Role> findAll() {
        return new HashSet<>(entityManager.createQuery("select r from Role r", Role.class)
                .getResultList());
    }
    @Override
    public List<Role> rolesList() {
        return new ArrayList<>(entityManager.createQuery("select r from Role r", Role.class).getResultList());
    }
}
