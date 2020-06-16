package com.meowmeow.dhateapp.Profile;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("profile")
@CrossOrigin("*")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/{username}")
    public UserProfile getProfile(@PathVariable("username") String username){
        UserProfile ret = userProfileService.get(username);
        ret.setAge(Integer.toString(2020-Integer.valueOf(ret.getBirthDate().split("/")[2])));
        return ret;
    }

    @GetMapping(value = "/picture/{username}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] test(@PathVariable("username") String username) throws IOException {
        return userProfileService.getProfilePic(username);
    }

    @GetMapping
    public UserProfile defaultCatch(){
        Interests temp = new Interests("Sport","Music", "Food", "Movie", "Book");
        UserProfile ret = new UserProfile("Meow", "Cat", "1/8/2001", "0101234567", "420, Purragon Alley, Meowntain View, Catlifornia 94035", temp);
        ret.setAge(Integer.toString(2020-Integer.valueOf(ret.getBirthDate().split("/")[2])));
        return ret;
    }

}
