package com.destaproject.user.infrastructure.datasource.jpa.repository;

import com.destaproject.user.infrastructure.datasource.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}