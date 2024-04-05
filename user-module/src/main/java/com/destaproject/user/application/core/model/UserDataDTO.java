package com.destaproject.user.application.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDataDTO {

    private Long id;
    private UUID secureId;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Timestamp emailVerifiedAt;
    private String name;
    private Integer regionCode;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
}
