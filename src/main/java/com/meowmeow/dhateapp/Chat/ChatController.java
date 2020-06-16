package com.meowmeow.dhateapp.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService chatService;

    @GetMapping("/{username}")
    public List<Conversation> getChats(@PathVariable("username") String username, @RequestParam("key")UUID key){
        return chatService.getConvos(username);
    }

}
