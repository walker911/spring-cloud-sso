package com.walker.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/1/31
 */
@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class SsoClientOneApplication {

    @Autowired
    private OAuth2RestTemplate restTemplate;
    @Value("${message.url:http://localhost:8085}/resource/api/")
    private String messageUrl;

    @RequestMapping("/api/{id}")
    public String home(@PathVariable String id) {
        return restTemplate.getForObject(messageUrl + id, String.class);
    }

    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }

    @Bean
    public OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails details, OAuth2ClientContext context) {
        return new OAuth2RestTemplate(details, context);
    }

    public static void main(String[] args) {
        SpringApplication.run(SsoClientOneApplication.class, args);
    }
}
