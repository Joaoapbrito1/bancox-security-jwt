package br.com.bancox_security_jwt.controllers;

import br.com.bancox_security_jwt.dtos.RegisterUserDto;
import br.com.bancox_security_jwt.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class RegisterUserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public void registerUser(@RequestBody RegisterUserDto registerUserDto){
        userServiceImpl.registerUser(registerUserDto);
    }
}