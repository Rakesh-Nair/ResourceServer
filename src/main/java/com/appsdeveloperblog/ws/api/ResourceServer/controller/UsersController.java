package com.appsdeveloperblog.ws.api.ResourceServer.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @GetMapping("/status/check")
    public String getStatus(){
        return "Service is Working";
    }

    @Secured("ROLE_developer")
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable String id){
        return "Deleted User with Id "+id;
    }
}
