package com.meowmeow.dhateapp.Chat;

import com.meowmeow.dhateapp.Authentication.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {
    @Autowired
    ChatService chatService;

    @Autowired
    AuthenticateService authenticateService;

    @GetMapping("/{username}")
    public List<Conversation> getChats(@PathVariable("username") String username, @RequestParam("key")UUID key){
        if(!authenticateService.internalAuth(username,key))return null;
        return chatService.getConvos(username);
    }

}
