package com.suyang.testclient.client;

import com.suyang.testclient.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User findById(Long id) {
        return new User(id, "默认用户", 0);
    }
}
