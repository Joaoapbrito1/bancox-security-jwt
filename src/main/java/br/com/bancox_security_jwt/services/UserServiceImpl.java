package br.com.bancox_security_jwt.services;

import br.com.bancox_security_jwt.dtos.RegisterUserDto;
import br.com.bancox_security_jwt.models.DepartmentModel;
import br.com.bancox_security_jwt.models.RoleModel;
import br.com.bancox_security_jwt.models.UserModel;
import br.com.bancox_security_jwt.repository.DepartmentRepository;
import br.com.bancox_security_jwt.repository.RoleRepository;
import br.com.bancox_security_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void registerUser(RegisterUserDto registerUserDto){
        if (userRepository.existsByUsername(registerUserDto.getUsername())){
            throw new RuntimeException("Unprocess Entity");
        }

        UserModel user = new UserModel();
        user.setUsername(registerUserDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registerUserDto.getPassword()));

        Set<RoleModel> roles = registerUserDto
                .getRoles()
                .stream()
                .map(r -> new RoleModel(r.name()))
                .collect(Collectors.toSet());
        roleRepository.saveAll(roles);

        user.setRoleModels(roles);

        DepartmentModel departmentModel = departmentRepository
                .findByName(registerUserDto.getDepartment())
                .orElseGet(() -> {
                    DepartmentModel newDepartmentModel = new DepartmentModel(registerUserDto.getDepartment());
                    return departmentRepository.save(newDepartmentModel);
                });
        user.setDepartmentModel(departmentModel);

        userRepository.save(user);

    }
}