package com.destaproject.user.application.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleDataDTO {

    private UserDataDTO user;
    private RoleDataDTO role;
    private Timestamp createdAt;
}
