package com.walker.sso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author walker
 * @date 2019/1/31
 */
@RestController
public class SsoController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
