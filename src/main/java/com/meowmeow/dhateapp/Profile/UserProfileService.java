package com.meowmeow.dhateapp.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    @Qualifier("UserTemplate")
    RedisTemplate<String, Object> redisTemplateUser;


    public UserProfile get(String username){
        return (UserProfile) redisTemplateUser.opsForHash().get(username,"profile");
    }

    public void uploadProfilePic(String username, byte[] bytes){
        redisTemplateUser.opsForHash().put(username, "picture",bytes);
    }

    public byte[] getProfilePic(String username){
        return (byte[])redisTemplateUser.opsForHash().get(username, "picture");
    }
}
