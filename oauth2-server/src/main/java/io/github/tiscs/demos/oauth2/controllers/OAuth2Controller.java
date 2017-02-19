package io.github.tiscs.demos.oauth2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@RestController
@SessionAttributes(value = "authorizationRequest")
public class OAuth2Controller {
    @RequestMapping("/user")
    @ResponseBody
    public Principal getUser(Principal user) {
        return user;
    }
}
