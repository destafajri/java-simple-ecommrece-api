package com.destaproject.user.infrastructure.adapters.persistance;

import com.destaproject.user.application.core.model.UserRoleDataDTO;
import com.destaproject.user.application.ports.outgoing.persistance.UserRolePersistencePort;
import com.destaproject.user.infrastructure.datasource.jpa.entity.embed.UserRoleKey;
import com.destaproject.user.infrastructure.datasource.jpa.repository.UserRoleReporsitory;
import com.destaproject.user.infrastructure.datasource.mapper.UserRoleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserRoleDataSourceAdapter implements UserRolePersistencePort {

    private UserRoleReporsitory userRoleReporsitory;

    @Override
    public UserRoleDataDTO addUserRole(UserRoleDataDTO userRoleDataDTO) {
        UserRoleKey entryPK = UserRoleKey.builder()
                .userId(userRoleDataDTO.getUser().getId())
                .roleId(userRoleDataDTO.getRole().getId())
                .build();

        var userRole = UserRoleMapper.INSTANCE.userRoleDataDtoToUserRole(userRoleDataDTO);
        userRole.setId(entryPK);

        log.info("user role: {}", userRole);
        var userRoleSaved = this.userRoleReporsitory.save(userRole);
        return UserRoleMapper.INSTANCE.userRoleToUserRoleDataDto(userRoleSaved);
    }
}
