package com.app.web_socket.domain.repository;

import com.app.web_socket.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
