package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
 private final RoleServiceImpl roleService;
 private final UserRepository userRepository;

 private final RoleRepository roleRepository;
 private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

 @Autowired
 public UserServiceImpl(RoleServiceImpl roleService, UserRepository userRepository, RoleRepository roleRepository) {
  this.roleService = roleService;
  this.userRepository = userRepository;
  this.roleRepository = roleRepository;
 }

 public List<User> getAllUsers() {
  return userRepository.findAll();
 }

 @Transactional
 public void saveUser(User user) {
  user.setPassword(passwordEncoder.encode(user.getPassword()));
   userRepository.save(user);
 }

 @Transactional
 @Override
 public void editUser(User user) {
  if (passwordEncoder.matches(user.getPassword(), userRepository.getById(user.getId()).getPassword())) {
   user.setPassword(passwordEncoder.encode(user.getPassword()));
   userRepository.edit(user);
  } else {
   userRepository.edit(user);
  }
 }


@Transactional
 public void removeUserById(Integer id) {
  userRepository.deleteById(id);
 }

 public User getUserById(Integer id) {
  return userRepository.getById(id);
 }

 public User findByUsername(String username) {
  return userRepository.findByUsername(username);
 }

 public List<Role> listRoles() {
  return roleService.getAllRoles();
 }

 @Override
 @Transactional
 public void deleteById(Integer id) {
  userRepository.deleteById(id);
 }

}
