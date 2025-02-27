package br.com.bancox_security_jwt.services;

import br.com.bancox_security_jwt.dtos.JwtResponse;
import br.com.bancox_security_jwt.dtos.LoginDto;

public interface AuthService {
    JwtResponse login(LoginDto loginDto);
}