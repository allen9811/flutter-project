package com.pradera.backend.controller;

import com.pradera.backend.model.UserDAO;
import com.pradera.backend.service.UserService;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public String createUser(@RequestBody UserDAO user) throws MessagingException, TemplateException, IOException {
        log.info("User creation started with incoming body: {}", user);
        return userService.createUser(user);
    }

    @GetMapping("/info/{userId}")
    public UserDAO getUserInformation(@PathVariable("userId") String userId) {
        log.info("User information extraction started with param: {}", userId);
        // TODO: Add security validation
        if (StringUtils.isBlank(userId)) {
            log.error("User id can not be blank");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id can not be blank");
        }
        return userService.extractUserInformation(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        log.info("User information extraction started with param: {}", userId);
        // TODO: Add security validation
        if (StringUtils.isBlank(userId)) {
            log.error("User id can not be blank");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id can not be blank");
        }
        userService.deleteUser(userId);
    }

}
