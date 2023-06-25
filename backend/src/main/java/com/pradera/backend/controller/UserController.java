package com.pradera.backend.controller;

import com.pradera.backend.model.UserDAO;
import com.pradera.backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDAO createUser(@RequestBody UserDAO user) {
        /*
        TODO: (1) Change User to Dto for testing purpose
              (2) Change to return ID only
         */
        return userService.createUser(user);
    }

}
