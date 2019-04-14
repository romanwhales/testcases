package com.eppress.demo.services;

import com.eppress.demo.entities.User;
import com.eppress.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(Integer userId){
        return userRepository.findById(userId);
    }

    @Secured("ROLE_USER")
    public void createUser(User user){
        userRepository.save(user);
    }

    @PreAuthorize("isAuthenticated()")
    public void updateUser(User user){
        userRepository.save(user);
    }

    @Secured("ROLE_ADMIN")
    public void deleteUser(Integer userId){
        userRepository.deleteById(userId);
    }
}
