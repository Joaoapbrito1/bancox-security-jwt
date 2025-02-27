package br.com.bancox_security_jwt.controllers;

import br.com.bancox_security_jwt.dtos.JwtResponse;
import br.com.bancox_security_jwt.dtos.LoginDto;
import br.com.bancox_security_jwt.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }
}
