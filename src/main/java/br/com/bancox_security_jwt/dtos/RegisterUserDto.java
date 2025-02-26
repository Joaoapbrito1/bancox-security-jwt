package br.com.bancox_security_jwt.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
@Data
public class RegisterUserDto {

    private String username;
    private String password;
    private Set<Roles> roles;
    private String department;

}