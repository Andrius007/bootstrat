package com.example.bootstrat.repository;


import com.example.bootstrat.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}