package com.appsdeveloperblog.ws.api.ResourceServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @GetMapping("/status/check")
    public String getStatus(){
        return "Service is Working";
    }
}
