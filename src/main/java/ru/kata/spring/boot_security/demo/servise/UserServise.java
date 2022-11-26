package ru.kata.spring.boot_security.demo.servise;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserServise {
    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void removeUserById(Long id);

    public void updateUser(User updatedUser);

    User findByUsername(String username);
    User passwordCoder(User user);
}
