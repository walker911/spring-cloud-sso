package com.walker.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author walker
 * @date 2019/1/31
 */
@Controller
public class LoginController {

    @GetMapping("/authentication/require")
    public String require() {
        return "login";
    }
}
