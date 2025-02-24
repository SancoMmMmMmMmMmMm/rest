package ru.kata.spring.boot_security.demo.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User getUserById(Long id);

    List<Role> listRoles();


    void saveUser(User user);


    void updateUser(User user);


    void deleteUser(long id);

    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;


    User findByEmail(String email);
}
