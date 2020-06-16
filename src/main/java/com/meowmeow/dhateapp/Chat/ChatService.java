package com.meowmeow.dhateapp.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatService {

    @Autowired
    @Qualifier("ChatTemplate")
    RedisTemplate<String, Object> redisTemplate;

    public void test(){

    }
    public boolean checkForChat(String sender, String recipient){
        return redisTemplate.opsForHash().hasKey(sender,recipient);
    }
    public void startConvo(String sender, String recipient){
        // Form greeting
        String greeting = String.format("Hello %s, want to be friends?",recipient);
        // Create conversations
        Conversation one = new Conversation(null,recipient);
        Conversation two = new Conversation(null, sender);
        // Register the conversation with greeting
        redisTemplate.opsForList().leftPush(one.getUid().toString(), one.addMsgSelf(greeting));
        redisTemplate.opsForList().leftPush(two.getUid().toString(), two.addMsgOther(greeting));
        // Add conversation to both users map
        redisTemplate.opsForHash().put(sender, recipient,one);
        redisTemplate.opsForHash().put(recipient, sender,two);
    }

    public void addToConvo(String sender, String recipient, String msg){
        // Get the conversations
        Conversation own = (Conversation) redisTemplate.opsForHash().get(sender,recipient);
        Conversation other = (Conversation) redisTemplate.opsForHash().get(recipient,sender);
        // Add msg to db while updating conversation metadata
        redisTemplate.opsForList().leftPush(own.getUid().toString(), own.addMsgSelf(msg));
        redisTemplate.opsForList().leftPush(other.getUid().toString(), other.addMsgOther(msg));
        // Update conversation metadata
        redisTemplate.opsForHash().put(sender, recipient, own);
        redisTemplate.opsForHash().put(recipient,sender,other);
    }

    private Map<Object,Object> getConvoMeta(String user){
        return redisTemplate.opsForHash().entries(user);
    }

    private List<Message> getMessages(UUID uid){
        return (List<Message>)(Object)redisTemplate.opsForList().range(uid.toString(),0,-1);
    }

    public List<Conversation> getConvos(String user){
        List<Conversation> ret = new ArrayList<>();
        Map<Object, Object> conversations = getConvoMeta(user);
        for (Object i:conversations.keySet()) {
            Conversation singleConvo = (Conversation) conversations.get(i);
            singleConvo.setMsg(getMessages(singleConvo.getUid()));
            ret.add(singleConvo);
        }
        return ret;
    }

    public void clearUnread(String reader, String opposingParty){
        // Get metadata
        Conversation a = (Conversation) redisTemplate.opsForHash().get(reader,opposingParty);
        // Update metadata
        a.clearUnread();
        redisTemplate.opsForHash().put(reader,opposingParty, a);
    }

}
