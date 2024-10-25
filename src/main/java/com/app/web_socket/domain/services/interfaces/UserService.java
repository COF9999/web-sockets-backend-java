package com.app.web_socket.domain.services.interfaces;

import com.app.web_socket.dtos.user.UserResponseDto;
import com.app.web_socket.models.User;

public interface UserService {

    User save(User user);

    User findByIdUser(Long id);

    UserResponseDto convertToDto(User user);
}
