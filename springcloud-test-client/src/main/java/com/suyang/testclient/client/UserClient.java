package com.suyang.testclient.client;

import com.suyang.testclient.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "test-server", fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("/api/v1/test-server/user/{id}")
    User findById(@PathVariable("id") Long id);
}
