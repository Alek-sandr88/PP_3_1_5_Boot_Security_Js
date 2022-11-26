package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.RoleServis;
import ru.kata.spring.boot_security.demo.servise.UserServise;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserTest implements ApplicationRunner {

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

    @Override
    public void run(ApplicationArguments args) {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        Set<Role> rolAdmin = new HashSet<>();
        Set<Role> rolUser = new HashSet<>();

        rolAdmin.add(roleAdmin);
        rolUser.add(roleUser);

        User UserRolAdmin = new User("admin", "admin",
                "admin", "admin", rolAdmin);

        User userRolUser = new User("user", "user",
                "user", "user", rolUser);

        roleServis.addRole(roleAdmin);
        roleServis.addRole(roleUser);
        userServise.saveUser(UserRolAdmin);
        userServise.saveUser(userRolUser);

    }
}
