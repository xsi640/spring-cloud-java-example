package com.suyang.testserver.controller;

import com.suyang.testserver.config.ConfigTest;
import com.suyang.testserver.domain.User;
import com.suyang.testserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping("/api/v1/test-server/user/")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Value("${hello.name}")
    private String name;
    @Autowired
    private ConfigTest configTest;

    @GetMapping("{id}")
    public User findById(@PathVariable("id") long id) {
        System.out.println("invoke find by id " + id);
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("hello")
    public String hello() {
        return name;
    }

    @GetMapping("hello2")
    public String hello2() {
        return configTest.getName1() + " " + configTest.getName2() + " " + configTest.getName3();
    }
}
