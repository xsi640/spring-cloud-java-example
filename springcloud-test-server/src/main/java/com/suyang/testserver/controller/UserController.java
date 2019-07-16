package com.suyang.testserver.controller;

import com.suyang.testserver.config.ConfigTest;
import com.suyang.testserver.domain.User;
import com.suyang.testserver.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RefreshScope
@RequestMapping("/api/v1/test-server/user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Value("${hello.name}")
    private String name;
    @Autowired
    private ConfigTest configTest;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") long id) {
        log.info("findById id:" + id);
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<User> findAll() {
        log.info("findAll");
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        log.info("save user:" + user);
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        log.info("update user:" + user);
        return userRepository.save(user);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        log.info("delete user id:" + id);
        userRepository.deleteById(id);
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
