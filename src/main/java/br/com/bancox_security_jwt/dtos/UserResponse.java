package br.com.bancox_security_jwt.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    private String message;
    private String department;

    public UserResponse(String message, String department) {
        this.message = message;
        this.department = department;
    }

}