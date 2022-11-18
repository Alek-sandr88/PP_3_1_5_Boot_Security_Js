package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.UserServise;

import java.util.List;

@RestController
@RequestMapping("admin/api/users")
public class AdminRestController {

    private UserServise userServise;

    @Autowired
    public void setUserServise(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping()
    public List<User> showAllUsers() {
        List<User> allUsers = userServise.getAllUsers();
        return allUsers;
    }

    @GetMapping("{id}")
    public User showById(@PathVariable("id") long id) {
        return userServise.getUserById(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        userServise.saveUser(user);
        return user;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        userServise.removeUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("{id}")
    public User updateUser(@RequestBody User user) {
        userServise.updateUser(user);
        return user;
    }
}
