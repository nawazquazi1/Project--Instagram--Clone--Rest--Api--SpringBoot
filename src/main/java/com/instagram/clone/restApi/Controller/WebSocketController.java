package com.instagram.clone.restApi.Controller;


import com.instagram.clone.restApi.model.Message;
import com.instagram.clone.restApi.payloads.SendMessageRequest;
import com.instagram.clone.restApi.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@AllArgsConstructor
public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;


    @MessageMapping("/message")
    public Message sendMessage(@Payload Message message) {

        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setUserId(message.getUser().getId());
        sendMessageRequest.setChatId(message.getChat().getId());
        sendMessageRequest.setContent(message.getMessageText());
        this.messageService.saveMessage(sendMessageRequest);
        simpMessagingTemplate.convertAndSendToUser(
                message.getUser().getId().toString(), "/queue/messages", message
        );
        return message;
    }


    @MessageMapping("/message")
    @SendTo("/group/public")
    public Message sendMessageToGroup(@Payload Message message) {
        simpMessagingTemplate.convertAndSend(message.getUser().getId().toString() + "/group/messages", message);
        SendMessageRequest request = new SendMessageRequest();
        request.setUserId(message.getUser().getId());
        request.setChatId(message.getChat().getId());
        request.setContent(message.getMessageText());
        this.messageService.saveMessage(request);
        return message;
    }
}
