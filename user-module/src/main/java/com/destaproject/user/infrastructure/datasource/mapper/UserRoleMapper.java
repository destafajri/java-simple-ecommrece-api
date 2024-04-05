package com.destaproject.user.infrastructure.datasource.mapper;

import com.destaproject.user.application.core.model.UserRoleDataDTO;
import com.destaproject.user.infrastructure.datasource.jpa.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    UserRoleDataDTO userRoleToUserRoleDataDto(UserRole userRole);

    UserRole userRoleDataDtoToUserRole(UserRoleDataDTO userRoleDataDTO);

    List<UserRoleDataDTO> userRoleListToUserRoleDataDtoList(List<UserRole> userRoleList);

    List<UserRole> userRoleDataDtoListToUserRoleList(List<UserRoleDataDTO> userRoleDataDTOList);
}
