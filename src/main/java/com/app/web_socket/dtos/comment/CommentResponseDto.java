package com.app.web_socket.dtos.comment;

import com.app.web_socket.dtos.user.UserResponseDto;

public record CommentResponseDto(String id, String idComment, String message, UserResponseDto userResponseDto) {
}
