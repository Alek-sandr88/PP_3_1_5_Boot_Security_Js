package ru.kata.spring.boot_security.demo.servise;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserServise extends UserDetailsService {
    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void removeUserById(Long id);
    public void updateUser(User updatedUser);

    public List<Role> listRoles();

    User findByUsername(String username);
}
