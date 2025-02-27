package br.com.bancox_security_jwt.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "departments")
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public DepartmentModel() {
    }

    public DepartmentModel(String name) {
        this.name = name;
    }

}