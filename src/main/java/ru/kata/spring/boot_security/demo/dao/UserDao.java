package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void removeUserById(Long id);

    public List<Role> listRoles();

    User findByUsername(String username);
}
