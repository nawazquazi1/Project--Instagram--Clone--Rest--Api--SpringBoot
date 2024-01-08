package com.instagram.clone.restApi.services.impl;

import com.instagram.clone.restApi.exception.ResourceNotFoundException;
import com.instagram.clone.restApi.model.Chat;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.GroupChatRequest;
import com.instagram.clone.restApi.repositories.ChatRepo;
import com.instagram.clone.restApi.repositories.UserRepo;
import com.instagram.clone.restApi.services.ChatService;
import com.instagram.clone.restApi.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
    private ChatRepo chatRepo;
    private UserRepo userRepo;
    private UserService userService;
    private ModelMapper modelMapper;


    @Override
    public Chat createChat(Long userId, User reqUser) {
        User user = this.modelMapper.map(this.userService.findById(userId), User.class);
        Chat isChatExist = this.chatRepo.findSingleChatByUserId(user, reqUser);
        if (isChatExist != null) {
            return isChatExist;
        }
        Chat chat = new Chat();
        chat.setCreateBy(reqUser);
        chat.getUsers().add(user);
        chat.getUsers().add(reqUser);
        chat.setGroup(false);
        return this.chatRepo.save(chat);
    }

    @Override
    public List<Chat> findAllChatByUserId(Long userId) {
        User user = this.modelMapper.map(this.userService.findById(userId), User.class);
        return this.chatRepo.findByUsersId(user.getId());
    }

    @Override
    public Chat findChatByChatId(Long chatId) {
        return this.chatRepo.findById(chatId).orElseThrow(() -> new ResourceNotFoundException("Chat", "id", chatId));
    }

    @Override
    public Chat createGroup(GroupChatRequest request, User reqUser) {
        return null;
    }

    @Override
    public Chat addUserToGroup(Long userId, Long chatId, User reqUser) {
        return null;
    }

    @Override
    public Chat reNameGroup(Long chatId, String groupName, User reqUser) {
        return null;
    }

    @Override
    public Chat removeFromGroup(Long chatId, Long userId, User reqUser) {
        return null;
    }

    @Override
    public void deleteChat(Long chatId, Long UserId) {
    }
}
