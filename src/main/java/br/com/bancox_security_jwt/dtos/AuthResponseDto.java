package br.com.bancox_security_jwt.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponseDto {
    private String accessToken;

}