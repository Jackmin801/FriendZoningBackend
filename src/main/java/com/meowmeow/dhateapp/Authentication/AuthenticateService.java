package com.meowmeow.dhateapp.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class AuthenticateService {

    @Autowired
    @Qualifier("UserTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    public UUID auth(String email, String pw){
        return (UUID)redisTemplate.opsForHash().get(email,pw);
    }

    public String getEmail(String username){
       return (String)redisTemplate.opsForHash().get(username,"email");
    }
}
