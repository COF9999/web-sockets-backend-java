package com.app.web_socket.domain.services.interfaces;

import com.app.web_socket.dtos.comment.CommentResponseDto;
import com.app.web_socket.models.Comment;

public interface CommentService {

    Comment save(Comment comment);

    CommentResponseDto convertToDto(Comment user);
}
