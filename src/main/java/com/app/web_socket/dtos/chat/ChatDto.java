package com.app.web_socket.dtos.chat;


import com.app.web_socket.dtos.comment.CommentDto;

public record ChatDto(String idChat, CommentDto commentDto) {
}
