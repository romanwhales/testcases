package com.eppress.demo.controllers;

import com.eppress.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {
    @Autowired
    private UserService userService;

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/admin/users/{id}")
    public void deleteUser(@PathVariable("id") Integer userid){
        userService.deleteUser(userid);
        System.err.println("User Deleted");
    }
}
