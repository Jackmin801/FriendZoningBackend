package com.meowmeow.dhateapp.Socket;

import com.meowmeow.dhateapp.Authentication.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Service
public class SocketService {

    @Autowired
    AuthenticateService authenticateService;

    private HashMap<String, String> socketIdToUser;
    private HashMap<String, WebSocketSession> userToSocket;

    public SocketService(){
        socketIdToUser = new HashMap<>();
        userToSocket = new HashMap<>();
    }
    public boolean checkOnline(String username){
        return userToSocket.containsKey(username);
    }
    public WebSocketSession getUsersSocket(String username){
        if(userToSocket.containsKey(username)){
            // User is online
            return userToSocket.get(username);
        }else{
            // User is offline
            return null;
        }
    }

    public String getUsernameFromId(String id){
        return socketIdToUser.get(id);
    }

    public boolean claimSocket(WebSocketSession session, String username, UUID key){
        // Authenticate?
        if(!authenticateService.internalAuth(username,key))return false;
        // Assign socketId to the user
        socketIdToUser.put(session.getId(),username);
        // Close previous socket to user
        if(userToSocket.containsKey(username)){
            try{
                userToSocket.get(username).close();
            }catch (Exception e){
                System.out.println("Something strange is going on");
                e.printStackTrace();
            }
        }
        // Assign user to session (if others need to reach)
        userToSocket.put(username,session);
        return true;
    }

    public void closeSocket(String socketId){
        // remove user from live sockets
        userToSocket.remove(socketIdToUser.get(socketId));
        // un-assign socketId
        socketIdToUser.remove(socketId);
    }
}
