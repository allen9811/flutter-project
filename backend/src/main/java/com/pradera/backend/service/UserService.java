package com.pradera.backend.service;

import com.pradera.backend.model.UserDAO;
import com.pradera.backend.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDAO createUser(UserDAO user) {
        //TODO Validate if user exists/creation/return of data
        if (userRepository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new EntityExistsException("Phone number or email is already registered");
        }
        //TODO Parse dates to timestamp
        return userRepository.save(user);
    }
}
