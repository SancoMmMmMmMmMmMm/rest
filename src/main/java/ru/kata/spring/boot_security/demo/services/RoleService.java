package ru.kata.spring.boot_security.demo.services;

import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.List;

public interface RoleService {

    @Transactional
    List<Role> getRoles();

    @Transactional
    Role getRoleById(Long id);

    @Transactional
    void saveRole(Role role);
}
