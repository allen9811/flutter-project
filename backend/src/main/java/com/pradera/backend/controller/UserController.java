package com.pradera.backend.controller;

import com.pradera.backend.model.UserDAO;
import com.pradera.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserDAO user) {
        return userService.createUser(user);
    }

    @GetMapping("/info/{userId}")
    public UserDAO getUserInformation(@PathVariable String userId) {
        // TODO: Add security validation
        return userService.extractUserInformation(userId);
    }

}
