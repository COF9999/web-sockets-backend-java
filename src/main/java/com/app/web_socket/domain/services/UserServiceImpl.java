package com.app.web_socket.domain.services;

import com.app.web_socket.domain.repository.UserRepository;
import com.app.web_socket.domain.services.interfaces.UserService;
import com.app.web_socket.dtos.user.UserResponseDto;
import com.app.web_socket.models.User;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByIdUser(Long id) {
        return userRepository.findByIdUser(id).orElseThrow(()-> new NoSuchElementException("Not found Id of user"));
    }

    @Override
    public UserResponseDto convertToDto(User user) {
        return new UserResponseDto(user.getId(),user.getIdUser(),user.getName());
    }
}
