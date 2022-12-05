package com.test.raisin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RaisinApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaisinApplication.class, args);
    }

}
