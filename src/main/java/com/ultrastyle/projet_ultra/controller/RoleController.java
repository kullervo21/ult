package com.ultrastyle.projet_ultra.controller;

import com.ultrastyle.projet_ultra.repository.RoleRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@CrossOrigin("http://localhost:4200")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
