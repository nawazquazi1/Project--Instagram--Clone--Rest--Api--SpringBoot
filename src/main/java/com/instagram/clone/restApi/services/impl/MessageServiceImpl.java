package com.instagram.clone.restApi.services.impl;

import com.instagram.clone.restApi.exception.NotAllowedException;
import com.instagram.clone.restApi.exception.ResourceNotFoundException;
import com.instagram.clone.restApi.model.Chat;
import com.instagram.clone.restApi.model.Message;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.SendMessageRequest;
import com.instagram.clone.restApi.repositories.MessageRepo;
import com.instagram.clone.restApi.services.ChatService;
import com.instagram.clone.restApi.services.MessageService;
import com.instagram.clone.restApi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private ChatService chatService;
    private UserService userService;
    private MessageRepo messageRepo;

    @Override
    public Message saveMessage(SendMessageRequest messageRequest) {
        User user = this.userService.dtoToUser(this.userService.findById(messageRequest.getUserId()));
        Chat chat = this.chatService.findChatByChatId(messageRequest.getChatId());
        Message message = new Message();
        message.setChat(chat);
        message.setUser(user);
        message.setMessageText(messageRequest.getContent());
        message.setInstant(Instant.now());
        return this.messageRepo.save(message);
    }

    @Override
    public List<Message> getChatMessages(Long chatId) {
        return this.messageRepo.findByChatId(chatId).orElseThrow(() -> new ResourceNotFoundException("chat", "id", chatId));
    }

    @Override
    public Message findMessageBYId(Long messageId) {
        return this.messageRepo.findById(messageId).orElseThrow(() -> new ResourceNotFoundException("Message", "id", messageId));
    }

    @Override
    public void deleteMessage(Long messageId, User reqUser) {
        Message message = this.findMessageBYId(messageId);
        if (message.getUser().equals(reqUser)) {
            this.messageRepo.deleteById(messageId);
        }

        throw new NotAllowedException("user", "message", "delete");

    }
}
