package br.com.bancox_security_jwt.repository;

import br.com.bancox_security_jwt.models.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    Optional<DepartmentModel> findByName(String name);
}