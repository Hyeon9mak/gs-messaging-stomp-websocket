package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final SimpMessagingTemplate template;

    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/chat")
    public void chat(MessageDto message) {
        template.convertAndSend("/topic/" + message.getCurrentRoom(), message);
    }
}
