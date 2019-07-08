package com.suyang.testserver;

import com.suyang.testserver.domain.User;
import com.suyang.testserver.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner init(UserRepository userRepository) {
        return args -> {
            User user1 = new User(1L, "张三", 20);
            User user2 = new User(2L, "李四", 28);
            User user3 = new User(3L, "王五", 32);
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        };
    }
}
