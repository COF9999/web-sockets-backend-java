package com.app.web_socket.controller;

import com.app.web_socket.domain.services.interfaces.ChatService;
import com.app.web_socket.dtos.chat.ChatResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatControllerRest {

    private final ChatService chatService;

    public ChatControllerRest(ChatService chatService){
        this.chatService = chatService;
    }

    // Se puede devolver un Chat
    @PostMapping("/list/{idChat}")
    public ChatResponseDto createChat(@PathVariable String idChat){
        return chatService.createChat(idChat);
    }
}
