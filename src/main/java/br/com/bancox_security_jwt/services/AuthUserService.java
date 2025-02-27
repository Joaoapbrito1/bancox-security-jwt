package br.com.bancox_security_jwt.services;


import br.com.bancox_security_jwt.dtos.UserResponse;

public interface AuthUserService {
    UserResponse getUserInfo(String token);
    String adminAccess();
}
