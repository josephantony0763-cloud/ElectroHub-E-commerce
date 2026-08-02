package com.antony.electronicstore.controller;

import com.antony.electronicstore.dto.request.RegisterRequest;
import com.antony.electronicstore.dto.response.RegisterResponse;
import com.antony.electronicstore.entity.User;
import com.antony.electronicstore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService ;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request){
        return userService.registerUser(request);
    }

}
