package com.suyang.testclient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableApolloConfig
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class TestClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestClientApplication.class, args);
    }
}
