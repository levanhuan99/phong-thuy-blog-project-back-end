package com.project.medium.controllers;

import com.project.medium.model.auth.Role;
import com.project.medium.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping
    public ResponseEntity<Iterable<Role>> getAllRole(){
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role), HttpStatus.OK);
    }
}
