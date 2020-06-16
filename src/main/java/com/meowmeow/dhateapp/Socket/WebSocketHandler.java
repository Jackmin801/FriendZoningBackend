package com.meowmeow.dhateapp.Socket;

import com.meowmeow.dhateapp.Chat.ChatService;
import com.meowmeow.dhateapp.Profile.UserProfileService;
import com.meowmeow.dhateapp.troll.TrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Controller
public class WebSocketHandler extends AbstractWebSocketHandler {
    @Autowired
    TestController testController;

    @Autowired
    SocketService socketService;

    @Autowired
    ChatService chatService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    TrollService trollService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String[] words = message.getPayload().split(" ",3);
        String sender="";
        String recipient="";
        switch(words[0]){
            case "CLAIM":
                if(socketService.claimSocket(session,words[1])){
                    System.out.println(words[1]+" claims "+session.getId()+" using key "+words[2]);
                }
                break;
            case "START":
                sender = socketService.getUsernameFromId(session.getId());
                recipient = words[1];
                // If there is already a chat, dont start
                if(chatService.checkForChat(sender,recipient))return;
                System.out.println(String.format("%s started a conversation with %s",sender,recipient));
                // Start chat
                chatService.startConvo(sender,recipient);
                // Check if recipient is online to update
                System.out.println(recipient+" online? : "+socketService.checkOnline(words[1]));
                if(socketService.checkOnline(recipient)) {
                    TextMessage update = new TextMessage("NEW " + "@" + sender);
                    socketService.getUsersSocket(recipient).sendMessage(update);
                }
                break;
            case "READ":
                sender = socketService.getUsernameFromId(session.getId());
                recipient = words[1];
                chatService.clearUnread(sender, recipient);
                System.out.println(String.format("%s read messages from %s",sender,recipient));
                break;
            case "CHECK":
                recipient = words[1];
                if(socketService.checkOnline(recipient)){
                    session.sendMessage(new TextMessage("ON"));
                }else{
                    session.sendMessage(new TextMessage("OFF"));
                }
                break;
            case "MSG":
                sender = socketService.getUsernameFromId(session.getId());
                recipient = words[1];
                System.out.println(String.format("%s sent a message to %s",sender,recipient));
                String msg = trollService.trollify(words[2]);
                // Update Model
                chatService.addToConvo(sender,recipient,msg);
                // Update View
                if(socketService.checkOnline(recipient)) {
                    TextMessage update = new TextMessage(sender + ":" + msg);
                    socketService.getUsersSocket(recipient).sendMessage(update);
                }
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        System.out.println("New Binary Received");
        String username = socketService.getUsernameFromId(session.getId());
        userProfileService.uploadProfilePic(username,message.getPayload().array());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session.getId()+" has connected, awaiting claim...");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(socketService.getUsernameFromId(session.getId()) +" has disconnected");
        socketService.closeSocket(session.getId());
    }
}
