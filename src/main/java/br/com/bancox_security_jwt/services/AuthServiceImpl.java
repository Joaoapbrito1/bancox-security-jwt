package br.com.bancox_security_jwt.services;

import br.com.bancox_security_jwt.dtos.LoginDto;
import br.com.bancox_security_jwt.infra.jwt.JwtTokenProvider;
import br.com.bancox_security_jwt.models.UserModel;
import br.com.bancox_security_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserRepository userRepository;

    public String login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);


            UserModel user = userRepository
                    .findByUsername(loginDto.getUsername())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


            String department = user.getDepartmentModel().getName();

            String token = jwtTokenProvider.generateToken(authentication,department);

            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao autenticar o usuário");
        }
    }
}