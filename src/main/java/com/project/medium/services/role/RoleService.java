package com.project.medium.services.role;

import com.project.medium.model.auth.Role;
import com.project.medium.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRole{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(Long id) {
        roleRepository.deleteById(id);
    }
}
