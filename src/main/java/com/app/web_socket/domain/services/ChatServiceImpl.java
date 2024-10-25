package com.app.web_socket.domain.services;

import com.app.web_socket.domain.repository.ChatRepository;
import com.app.web_socket.domain.repository.UserRepository;
import com.app.web_socket.domain.services.interfaces.ChatService;
import com.app.web_socket.domain.services.interfaces.CommentService;
import com.app.web_socket.domain.services.interfaces.UserService;
import com.app.web_socket.domain.services.interfaces.basic.ChatBasicService;
import com.app.web_socket.dtos.chat.ChatDto;
import com.app.web_socket.dtos.chat.ChatResponseDto;
import com.app.web_socket.dtos.comment.CommentDto;
import com.app.web_socket.dtos.comment.CommentResponseDto;
import com.app.web_socket.models.Chat;
import com.app.web_socket.models.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ChatServiceImpl implements ChatService, ChatBasicService {

    private final ChatRepository chatRepository;

    private final UserService userService;

    private final CommentService commentService;

    public ChatServiceImpl(ChatRepository chatRepository, UserService userService, CommentService commentService) {
        this.chatRepository = chatRepository;
        this.userService = userService;
        this.commentService = commentService;
    }

    @Transactional(readOnly = true)
    public Chat findByIdChat(String id){
        return chatRepository.findByIdChat(id).orElseThrow(()-> new NoSuchElementException("Id chat: "+id+" Not found"));
    }


    @Override
    public ChatResponseDto createChat(String idChat) {
        Chat chatDb = null;
        try {
            chatDb = findByIdChat(idChat);
        }catch (NoSuchElementException e){
            Chat newChat = new Chat();
            newChat.setIdChat(idChat);
            chatDb = save(newChat);
        }
        return Optional.ofNullable(chatDb)
                .map(this::convertToDto)
                .orElseThrow();
    }

    @Override
    public ChatResponseDto createMessagesInChat(ChatDto chatDto){

        System.out.println(chatDto);

        Chat chatDb = Optional.of(chatDto.idChat())
                .map(this::findByIdChat)
                .orElseThrow();

        CommentDto commentDtoRequest = chatDto.commentDto();
        Comment comment = Optional.of(commentDtoRequest)
                .map(commentDto-> userService.findByIdUser(commentDto.idUser()))
                .map(user -> new Comment(commentDtoRequest.message(),user))
                .map(commentService::save)
                .orElseThrow(()->  new NoSuchElementException("Not posible CreateComment"));

        chatDb.getCommentList().add(comment);
        return Optional.of(save(chatDb))
                .map(this::convertToDto)
                .orElseThrow();
    }



    @Override
    public Chat save(Chat chat){
        return chatRepository.save(chat);
    }

    @Override
    @Transactional(readOnly = true)
    public ChatResponseDto convertToDto(Chat chat){
        List<CommentResponseDto> commentResponseDtoList = chat.getCommentList()
                .stream().map(commentService::convertToDto)
                .toList();

        return new ChatResponseDto(chat.getId(),chat.getIdChat(),commentResponseDtoList);
    }





}
