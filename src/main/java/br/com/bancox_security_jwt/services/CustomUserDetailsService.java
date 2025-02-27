package br.com.bancox_security_jwt.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {
    UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
}