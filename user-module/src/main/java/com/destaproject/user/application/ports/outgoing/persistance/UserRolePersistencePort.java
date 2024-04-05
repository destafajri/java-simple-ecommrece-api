package com.destaproject.user.application.ports.outgoing.persistance;

import com.destaproject.user.application.core.model.UserRoleDataDTO;

public interface UserRolePersistencePort {
    UserRoleDataDTO addUserRole(UserRoleDataDTO userRoleDataDTO);
}
