package com.meowmeow.dhateapp.Registration;

import com.meowmeow.dhateapp.Profile.UserProfile;
import com.meowmeow.dhateapp.Search.Coordinate;
import com.meowmeow.dhateapp.Search.RadCoordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrationService {

    @Autowired
    @Qualifier("UserTemplate")
    private RedisTemplate<String, Object> redisTemplateUser;

    public boolean check(LoginCredentials loginCredentials){
        //Check if email is used
        boolean ret = redisTemplateUser.opsForHash().entries(loginCredentials.getEmail()).size()==0;
        //Check if username is used
        ret &= redisTemplateUser.opsForHash().entries(loginCredentials.getUsername()).size()==0;
        return ret;
    }

    public void registerProfile(UserProfile profile){
        redisTemplateUser.opsForHash().put(profile.getUsername(),"profile",profile);
    }

    public void registerLogin(LoginCredentials loginCredentials){
        redisTemplateUser.opsForHash().put(loginCredentials.getUsername(),"email",loginCredentials.getEmail());
        redisTemplateUser.opsForHash().put(loginCredentials.getEmail(),loginCredentials.getPassword(), UUID.randomUUID());
    }

    private RadCoordinate convertToRad(Coordinate coord){
        return new RadCoordinate(Double.valueOf(coord.getLat())*Math.PI/180,Double.valueOf(coord.getLon())*Math.PI/180);
    }
    public void registerCoords(String username, String gender, Coordinate coordinate){
        redisTemplateUser.opsForHash().put(username,"coord",coordinate);
        redisTemplateUser.opsForHash().put("COORD"+gender,username,convertToRad(coordinate));
        System.out.println(redisTemplateUser.opsForHash().entries("COORD"+gender));
    }
}
