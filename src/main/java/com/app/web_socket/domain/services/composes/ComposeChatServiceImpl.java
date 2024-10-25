package com.app.web_socket.domain.services.composes;

import com.app.web_socket.domain.services.composes.interfaces.ComposeChatService;
import com.app.web_socket.domain.services.interfaces.ChatService;
import com.app.web_socket.dtos.chat.ChatDto;
import com.app.web_socket.models.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ComposeChatServiceImpl implements ComposeChatService {

    private final ChatService chatService;

    public ComposeChatServiceImpl(ChatService chatService){
        this.chatService = chatService;
    }

    @Override
    public Comment chatProcessBuild(ChatDto chatDto) {
        return null;
    }
}
