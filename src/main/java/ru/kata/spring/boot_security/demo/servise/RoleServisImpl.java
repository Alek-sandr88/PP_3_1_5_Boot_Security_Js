package ru.kata.spring.boot_security.demo.servise;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

@Service
public class RoleServisImpl implements RoleServis {
    private final RoleDao roleDAO;

    public RoleServisImpl(RoleDao roleDAO) {
        this.roleDAO = roleDAO;
    }


    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    public Role findById(long id) {
        return roleDAO.findById(id);
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        return roleDAO.findByIdRoles(roles);
    }
}
