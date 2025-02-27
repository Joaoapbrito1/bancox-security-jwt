package br.com.bancox_security_jwt.services;

import br.com.bancox_security_jwt.dtos.RegisterUserDto;

public interface UserService {

   public void registerUser(RegisterUserDto registerUserDto);
}