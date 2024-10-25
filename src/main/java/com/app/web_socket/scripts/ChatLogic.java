package com.app.web_socket.scripts;

import com.app.web_socket.dtos.chat.ChatResponseDto;
import com.app.web_socket.dtos.comment.CommentResponseDto;

public class ChatLogic {

    public static CommentResponseDto lastComment(ChatResponseDto chatResponseDto){
        return chatResponseDto.commentResponseDto().getLast();
    }
}
