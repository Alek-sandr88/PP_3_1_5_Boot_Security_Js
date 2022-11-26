package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.exception.ExceptionInfo;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.RoleServis;
import ru.kata.spring.boot_security.demo.servise.UserServise;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("admin/api/users")
public class AdminRestController {

    private UserServise userServise;
    private RoleServis roleServis;

    @Autowired
    public void setRoleServis(RoleServis roleServis) {
        this.roleServis = roleServis;
    }

    @Autowired
    public void setUserServise(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userServise.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        User user = userServise.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ExceptionInfo> createUser(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String error = getErrorsFromBindingResult(bindingResult);
            return new ResponseEntity<>(new ExceptionInfo(error), HttpStatus.BAD_REQUEST);
        }
        userServise.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<ExceptionInfo> pageDelete(@PathVariable("id") long id) {
        userServise.removeUserById(id);
        return new ResponseEntity<>(new ExceptionInfo("User deleted"), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExceptionInfo> pageEdit(@PathVariable("id") long id,
                                                  @RequestBody User user,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String error = getErrorsFromBindingResult(bindingResult);
            return new ResponseEntity<>(new ExceptionInfo(error), HttpStatus.BAD_REQUEST);
        }
        userServise.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    private String getErrorsFromBindingResult(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
    }
}
