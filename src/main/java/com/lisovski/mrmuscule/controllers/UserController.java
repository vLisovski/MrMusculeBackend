package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.models.User;
import com.lisovski.mrmuscule.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("getById/{userId}")
    public User getById(@PathVariable(name = "userId") int userId){
        return userService.getById(userId);
    }
}
