package com.example.starlight.talent.repository;

import com.example.starlight.talent.model.entity.ERole;
import com.example.starlight.talent.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(ERole name);
}