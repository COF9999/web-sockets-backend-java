package com.app.web_socket.domain.repository;

import com.app.web_socket.models.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRepository extends MongoRepository<Chat,String> {

    Optional<Chat> findByIdChat(String id);
}
