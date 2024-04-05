package com.destaproject.user.application.ports.outgoing.persistance;

import com.destaproject.user.application.core.model.UserDataDTO;

public interface UserPersistencePort {
    UserDataDTO addUser(UserDataDTO userDataDTO);
}
