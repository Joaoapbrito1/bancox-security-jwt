package br.com.bancox_security_jwt.controllers;

import br.com.bancox_security_jwt.dtos.UserResponse;
import br.com.bancox_security_jwt.services.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final AuthUserService authUserService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<?> adminRoute() {
        return ResponseEntity.ok(authUserService.adminAccess());
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        return ResponseEntity.ok(authUserService.getUserInfo(token));
    }
}
