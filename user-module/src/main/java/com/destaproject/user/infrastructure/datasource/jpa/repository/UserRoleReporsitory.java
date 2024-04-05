package com.destaproject.user.infrastructure.datasource.jpa.repository;

import com.destaproject.user.infrastructure.datasource.jpa.entity.UserRole;
import com.destaproject.user.infrastructure.datasource.jpa.entity.embed.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleReporsitory extends JpaRepository<UserRole, UserRoleKey> {
}
