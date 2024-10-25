package com.app.web_socket.domain.services.interfaces.basic;

import com.app.web_socket.models.Chat;

public interface ChatBasicService {

    Chat save(Chat chat);

    Chat findByIdChat(String id);
}
