package com.demo.spring;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String publicEndpoint() {
        return "Public API - No authentication required!";
    }

    @GetMapping("/private")
    public String privateEndpoint(@AuthenticationPrincipal OAuth2User user) {
        return "Hello " + user.getAttribute("preferred_username") + "! This is a protected resource.";
    }
}
