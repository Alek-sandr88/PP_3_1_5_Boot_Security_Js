package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }


    @Override
    public void removeUserById(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public List<Role> listRoles() {
        return entityManager.createQuery("select r from Role  r", Role.class).getResultList();
    }

    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("select c from User c where c.username = : username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
}