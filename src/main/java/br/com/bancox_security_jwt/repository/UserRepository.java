package br.com.bancox_security_jwt.repository;

import br.com.bancox_security_jwt.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);

    boolean existsByUsername(String username);
}
