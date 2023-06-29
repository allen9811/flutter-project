package com.pradera.backend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradera.backend.config.ControllerTest;
import com.pradera.backend.model.UserDAO;
import com.pradera.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ControllerTest(UserController.class)
class UserControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void createUser_userIsCreated_returnsCreated() throws Exception {
        // Given
        UserDAO userDao = objectMapper.readValue(new ClassPathResource("data/user/userDao.json").getFile(), UserDAO.class);

        // When
        mockMvc.perform(post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userDao)))
                .andExpect(status().isCreated());

        // Then
        verify(userService, times(1)).createUser(userDao);
    }

}
