package com.meowmeow.dhateapp.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
public class AuthenticateService {

    @Autowired
    @Qualifier("UserTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    public UUID auth(String email, String pw){
        return (UUID)redisTemplate.opsForHash().get(email,pw);
    }

    public boolean internalAuth(String username, UUID key){
        //return true;
        Map<Object, Object> temp = redisTemplate.opsForHash().entries(getEmail(username));
        UUID realKey = null;
        for (Object i:temp.keySet())realKey=(UUID)temp.get(i);
        return realKey.equals(key);
    }

    public String getEmail(String username){
       return (String)redisTemplate.opsForHash().get(username,"email");
    }
}
