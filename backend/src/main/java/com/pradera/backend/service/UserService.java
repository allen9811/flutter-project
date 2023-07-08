package com.pradera.backend.service;

import com.pradera.backend.model.UserDAO;
import com.pradera.backend.repository.UserRepository;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public Long createUser(UserDAO user) throws MessagingException, TemplateException, IOException {
        if (userRepository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new EntityExistsException("Phone number or email is already registered");
        }
        UserDAO created = userRepository.save(user);
        emailService.sendCreatedAccountEmail(created);
        return created.getId();
    }

    public UserDAO extractUserInformation(String userId) {
        return userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
