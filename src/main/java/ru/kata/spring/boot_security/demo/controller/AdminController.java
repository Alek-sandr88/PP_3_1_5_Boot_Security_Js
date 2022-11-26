package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.RoleServis;
import ru.kata.spring.boot_security.demo.servise.UserServise;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
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
    public String allUsers(Model model, @AuthenticationPrincipal User user) {
        List<User> users = userServise.getAllUsers();
        List<Role> listRoles = roleServis.getAllRoles();
        model.addAttribute("users", users);
        model.addAttribute("userObj", new User());
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("userRep", userServise.findByUsername(user.getUsername()));
        return "admin";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServise.getUserById(id));
        return "admin";
    }
}
