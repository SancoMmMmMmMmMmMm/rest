package ru.kata.spring.boot_security.demo.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    @Transactional(readOnly = true)
    List<User> findAll();

    @Transactional(readOnly = true)
    User getUserById(Long id);

    @Transactional(readOnly = true)
    List<Role> listRoles();

    @Transactional
    void saveUser(User user);

    @Transactional
    void updateUser(User user);

    @Transactional
    void deleteUser(long id);

    @Override
    @Transactional(readOnly = true)
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    @Transactional(readOnly = true)
    User findByEmail(String email);
}
