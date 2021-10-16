package com.parwaz.training.service;

import com.parwaz.training.model.ERole;
import com.parwaz.training.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(ERole name);
}
