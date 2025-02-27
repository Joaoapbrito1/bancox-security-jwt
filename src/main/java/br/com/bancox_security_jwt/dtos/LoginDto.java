package br.com.bancox_security_jwt.dtos;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class LoginDto {
    private String username;
    private String password;

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}