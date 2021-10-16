package com.parwaz.training.serviceImpl;

import com.parwaz.training.model.ERole;
import com.parwaz.training.model.Role;
import com.parwaz.training.repository.RoleRepository;
import com.parwaz.training.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }

}
