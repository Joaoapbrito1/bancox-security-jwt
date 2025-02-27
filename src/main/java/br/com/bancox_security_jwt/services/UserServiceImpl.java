package br.com.bancox_security_jwt.services;

import br.com.bancox_security_jwt.dtos.RegisterUserDto;
import br.com.bancox_security_jwt.models.DepartmentModel;
import br.com.bancox_security_jwt.models.RoleModel;
import br.com.bancox_security_jwt.models.UserModel;
import br.com.bancox_security_jwt.repository.DepartmentRepository;
import br.com.bancox_security_jwt.repository.RoleRepository;
import br.com.bancox_security_jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(RegisterUserDto registerUserDto) {
        if (userRepository.existsByUsername(registerUserDto.getUsername())) {
            throw new RuntimeException("Unprocess Entity");
        }

        UserModel user = new UserModel();
        user.setUsername(registerUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        Set<RoleModel> roles = registerUserDto.getRoles().stream()
                .map(r -> new RoleModel(r.name()))
                .collect(Collectors.toSet());
        roleRepository.saveAll(roles);

        user.setRoleModels(roles);

        DepartmentModel departmentModel = departmentRepository
                .findByName(registerUserDto.getDepartment())
                .orElseGet(() -> departmentRepository.save(new DepartmentModel(registerUserDto.getDepartment())));

        user.setDepartmentModel(departmentModel);

        userRepository.save(user);
    }
}