package com.destaproject.user.infrastructure.adapters.persistance;

import com.destaproject.user.application.core.model.UserDataDTO;
import com.destaproject.user.application.ports.outgoing.persistance.UserPersistencePort;
import com.destaproject.user.infrastructure.datasource.jpa.entity.User;
import com.destaproject.user.infrastructure.datasource.jpa.repository.UserRepository;
import com.destaproject.user.infrastructure.datasource.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserDataSourceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;

    @Override
    public UserDataDTO addUser(UserDataDTO userDataDTO) {
        User user = UserMapper.INSTANCE.userDataDtoToUser(userDataDTO);
        log.info("added user: {}", user);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDataDto(user);
    }
}
