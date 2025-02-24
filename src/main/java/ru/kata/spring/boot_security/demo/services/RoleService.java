package ru.kata.spring.boot_security.demo.services;

import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role getRoleById(Long id);

    void saveRole(Role role);
}
