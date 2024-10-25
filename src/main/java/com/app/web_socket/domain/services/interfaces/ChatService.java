package com.app.web_socket.domain.services.interfaces;

import com.app.web_socket.dtos.chat.ChatDto;
import com.app.web_socket.dtos.chat.ChatResponseDto;
import com.app.web_socket.dtos.comment.CommentResponseDto;
import com.app.web_socket.models.Chat;

public interface ChatService {

    ChatResponseDto createChat(String idChat);

    ChatResponseDto createMessagesInChat(ChatDto chatDto);

    ChatResponseDto convertToDto(Chat chat);

    static ChatResponseDto calculate(Chat chat){
        return null;
    }
}
