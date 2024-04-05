package com.destaproject.user.infrastructure.datasource.mapper;

import com.destaproject.user.application.core.model.UserDataDTO;
import com.destaproject.user.infrastructure.datasource.jpa.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDataDTO userToUserDataDto(User user);

    User userDataDtoToUser(UserDataDTO userDataDTO);

    List<UserDataDTO> userListToUserDataDtoList(List<User> userList);

    List<User> userDataDtoListToUserList(List<UserDataDTO> userDataDTOList);
}
