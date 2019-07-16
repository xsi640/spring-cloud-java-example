package com.suyang.testserver;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.suyang.testserver.domain.User;
import com.suyang.testserver.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableApolloConfig
@SpringBootApplication
public class TestServerApplication {
    private static final Logger logger = LoggerFactory.getLogger(TestServerApplication.class);


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
