package com.app.web_socket.controller;

import com.app.web_socket.domain.services.interfaces.ChatService;
import com.app.web_socket.dtos.chat.ChatDto;
import com.app.web_socket.dtos.comment.CommentDto;
import com.app.web_socket.dtos.comment.CommentResponseDto;
import com.app.web_socket.models.Comment;
import com.app.web_socket.scripts.ChatLogic;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class WebSocketController {

    // private final ComposeChatService composeChatService;
    private final ChatService chatService;

    public WebSocketController(ChatService chatService){
        this.chatService = chatService;
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public CommentResponseDto chat(@DestinationVariable String roomId, CommentDto commentDto){
        System.out.println("ENTRO BROKER");
        return Optional.of(chatService.createMessagesInChat(new ChatDto(roomId,commentDto)))
                .map(ChatLogic::lastComment)
                .orElseThrow(()-> new NoSuchElementException("Not posible return the last comment"));
    }


}
