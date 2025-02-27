package br.com.bancox_security_jwt.services;

import br.com.bancox_security_jwt.dtos.JwtResponse;
import br.com.bancox_security_jwt.dtos.LoginDto;
import br.com.bancox_security_jwt.infra.jwt.JwtTokenProvider;
import br.com.bancox_security_jwt.models.UserModel;
import br.com.bancox_security_jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    public JwtResponse login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserModel user = userRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String department = user.getDepartmentModel().getName();
        String token = jwtTokenProvider.generateToken(authentication, department);

        return new JwtResponse(token);
    }
}
