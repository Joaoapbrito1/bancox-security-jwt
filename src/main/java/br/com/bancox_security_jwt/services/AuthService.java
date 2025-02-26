package br.com.bancox_security_jwt.services;

import br.com.bancox_security_jwt.dtos.LoginDto;

public interface AuthService {

    String login(LoginDto loginDto);
}
