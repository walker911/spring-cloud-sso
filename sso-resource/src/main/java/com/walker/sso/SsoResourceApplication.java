package com.walker.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/2/11
 */
@RestController
@SpringBootApplication
public class SsoResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoResourceApplication.class, args);
    }

    @GetMapping("/api/{id}")
    public String get(@PathVariable("id") String id) {
        System.out.printf("id: %s\n", id);
        return "hello resource";
    }
}
