package com.springboot.crud.springbootcrud.Service;

import com.springboot.crud.springbootcrud.model.Role;
import com.springboot.crud.springbootcrud.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
