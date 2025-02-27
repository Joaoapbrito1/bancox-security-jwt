package br.com.bancox_security_jwt.services;


import br.com.bancox_security_jwt.dtos.UserResponse;
import br.com.bancox_security_jwt.infra.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserResponse getUserInfo(String token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("Usuário não autenticado");
        }

        String username = authentication.getName();
        String department = jwtTokenProvider.getDepartment(token);

        return new UserResponse("Bem-vindo, " + username + "!", department);
    }

    @Override
    public String adminAccess() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_USER"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado para usuários com o papel ROLE_USER");
        }

        return "Acesso admin";
    }
}
