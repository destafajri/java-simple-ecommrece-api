package com.destaproject.user.application.core.model;

import com.destaproject.user.application.core.types.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDataDTO {

    private int id;
    private RoleType roleName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
