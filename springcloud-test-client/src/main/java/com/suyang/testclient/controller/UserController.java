package com.suyang.testclient.controller;

import com.suyang.testclient.client.UserClient;
import com.suyang.testclient.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/test-client/user")
@RestController
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User findById(@PathVariable("id") long id) {
        return userClient.findById(id);
    }
}
