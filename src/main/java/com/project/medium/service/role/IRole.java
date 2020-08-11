package com.project.medium.service.role;

import com.project.medium.model.auth.Role;

public interface IRole {
    Role findByName(String name);
    Iterable<Role> findAll();
    Role findById(Long id);
    Role save(Role role);
    void remove(Long id);
}
