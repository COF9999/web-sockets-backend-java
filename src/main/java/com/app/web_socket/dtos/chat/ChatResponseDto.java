package com.app.web_socket.dtos.chat;

import com.app.web_socket.dtos.comment.CommentResponseDto;

import java.util.List;

public record ChatResponseDto(String id, String idChat, List<CommentResponseDto> commentResponseDto) {
}
