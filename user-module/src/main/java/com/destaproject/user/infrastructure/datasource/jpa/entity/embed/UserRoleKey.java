package com.destaproject.user.infrastructure.datasource.jpa.entity.embed;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class UserRoleKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "role_id")
    int roleId;
}
