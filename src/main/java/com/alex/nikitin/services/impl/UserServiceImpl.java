package com.alex.nikitin.services.impl;

import com.alex.nikitin.dao.UserDao;
import com.alex.nikitin.model.Role;
import com.alex.nikitin.model.User;
import com.alex.nikitin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> source = userDao.findAll();
        List<User> users = new ArrayList<>();
        source.forEach(user -> users.add(clearConfidentialInformation(user)));
        return users;
    }

    @Override
    public User createUser(User user) {
        User userToSave = new User();
        userToSave.setName(user.getName());
        userToSave.setSurname(user.getSurname());
        userToSave.setUsername(user.getUsername());
        userToSave.setPassword(passwordEncoder.encode(user.getPassword()));
        userToSave.setRoles(Arrays.asList(new Role("ROLE_USER")));

        try {
            return userDao.save(userToSave);
        } catch (Exception e) {
            throw new IllegalArgumentException("User with this username already exists");
        }
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userDao.findById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    private User clearConfidentialInformation(User user) {
        user.setPassword(null);
        user.setConfirmPassword(null);
        return user;
    }
}
