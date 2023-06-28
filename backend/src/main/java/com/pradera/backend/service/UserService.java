package com.pradera.backend.service;

import com.pradera.backend.model.UserDAO;
import com.pradera.backend.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(UserDAO user) {
        if (userRepository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new EntityExistsException("Phone number or email is already registered");
        }
        return userRepository.save(user).getId();
    }

    public UserDAO extractUserInformation(String userId) {
        return userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }
}
