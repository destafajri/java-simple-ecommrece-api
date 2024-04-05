package com.destaproject.user.infrastructure.datasource.mapper;

import com.destaproject.user.application.core.model.RoleDataDTO;
import com.destaproject.user.infrastructure.datasource.jpa.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDataDTO roleToRoleDataDto(Role role);

    Role roleDataDtoToRole(RoleDataDTO userDataDTO);

    List<RoleDataDTO> roleListToRoleDataDtoList(List<Role> roleList);

    List<Role> roleDataDtoListToRoleList(List<RoleDataDTO> roleDataDTOList);
}
