package com.instagram.clone.restApi.services;

import com.instagram.clone.restApi.model.Message;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.SendMessageRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    Message saveMessage(SendMessageRequest messageRequest);

    List<Message> getChatMessages(Long chatId);

    Message findMessageBYId(Long messageId);

    void deleteMessage(Long messageId, User reqUser);


}
