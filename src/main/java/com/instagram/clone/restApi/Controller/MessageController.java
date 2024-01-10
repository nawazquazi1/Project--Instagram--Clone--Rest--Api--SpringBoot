package com.instagram.clone.restApi.Controller;

import com.instagram.clone.restApi.model.Message;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.ApiResponse;
import com.instagram.clone.restApi.payloads.SendMessageRequest;
import com.instagram.clone.restApi.services.MessageService;
import com.instagram.clone.restApi.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inst/clone")
@AllArgsConstructor
public class MessageController {

    private MessageService messageService;
    private UserService userService;

    @PostMapping("/save/message")
    public ResponseEntity<Message> saveMessage(@RequestBody SendMessageRequest request, @AuthenticationPrincipal User user ) {
        request.setUserId(user.getId());
        Message message = this.messageService.saveMessage(request);
        return ResponseEntity.ok(message);
    }


    @GetMapping("/chat/{chatId}/messages")
    public ResponseEntity<List<Message>> getChatsMessage(@PathVariable("chatId") Long chatId) {
        List<Message> message = this.messageService.getChatMessages(chatId);
        return ResponseEntity.ok(message);
    }


    @DeleteMapping("/delete/message/{messageId}")
    public ResponseEntity<ApiResponse> deleteMessage(@PathVariable Long messageId, @AuthenticationPrincipal User user) {
        this.messageService.deleteMessage(messageId, user);
        ApiResponse apiResponse = new ApiResponse("Message deleted successfully", true);
        return ResponseEntity.ok(apiResponse);
    }

}
