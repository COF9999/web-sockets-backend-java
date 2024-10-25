package com.app.web_socket.domain.services;

import com.app.web_socket.domain.repository.CommentRepository;
import com.app.web_socket.domain.services.interfaces.CommentService;
import com.app.web_socket.domain.services.interfaces.UserService;
import com.app.web_socket.dtos.comment.CommentResponseDto;
import com.app.web_socket.dtos.user.UserResponseDto;
import com.app.web_socket.models.Comment;
import com.app.web_socket.models.User;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository,UserService userService){
        this.commentRepository = commentRepository;
        this.userService = userService;
    }


    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public CommentResponseDto convertToDto(Comment comment){
        return new CommentResponseDto(comment.getId(),null,comment.getMessage(),userService.convertToDto(comment.getUser()));
    }
}
