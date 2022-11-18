package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.UserServise;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserTest implements ApplicationRunner {

    private UserServise userServise;

    @Autowired
    public void setUserServise(UserServise userServise) {
        this.userServise = userServise;
    }

    @Override
    public void run(ApplicationArguments args) {
        Role roleAdmin = new Role( "ROLE_ADMIN");
        Role roleUser = new Role( "ROLE_USER");

        Set<Role> rolAdmin = new HashSet<>();
        Set<Role> rolUser = new HashSet<>();

        rolAdmin.add(roleAdmin);
        rolUser.add(roleUser);

        User UserRolAdmin = new User("Ivan", "user",
                "Ivanov", "ivan@iv", rolAdmin);

        User userRolUser = new User("Olga", "user",
                "Sidorova", "ol@ga", rolUser);


        userServise.saveUser(UserRolAdmin);
        userServise.saveUser(userRolUser);

    }
}
