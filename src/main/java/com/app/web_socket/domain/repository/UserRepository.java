package com.app.web_socket.domain.repository;

import com.app.web_socket.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByIdUser(Long id);
}
