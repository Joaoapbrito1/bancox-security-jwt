package br.com.bancox_security_jwt.repository;

import br.com.bancox_security_jwt.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel,Long> {
}
