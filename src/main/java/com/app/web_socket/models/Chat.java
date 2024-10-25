package com.app.web_socket.models;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "chats")
@TypeAlias("chat")
public class Chat {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String idChat;

    private List<Comment> commentList = new ArrayList<>();

    public Chat(String idChat, List<Comment> commentList) {
        this.idChat = idChat;
        this.commentList = commentList;
    }

    public Chat(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
