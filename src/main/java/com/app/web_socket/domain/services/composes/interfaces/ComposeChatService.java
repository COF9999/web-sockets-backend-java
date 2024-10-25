package com.app.web_socket.domain.services.composes.interfaces;

import com.app.web_socket.dtos.chat.ChatDto;
import com.app.web_socket.models.Comment;

public interface ComposeChatService {

    Comment chatProcessBuild(ChatDto chatDto);
}
