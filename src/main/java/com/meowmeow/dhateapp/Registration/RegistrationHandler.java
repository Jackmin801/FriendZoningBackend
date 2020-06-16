package com.meowmeow.dhateapp.Registration;

import com.meowmeow.dhateapp.Profile.Interests;
import com.meowmeow.dhateapp.Profile.UserProfile;
import com.meowmeow.dhateapp.Search.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin("*")
public class RegistrationHandler {

    @Autowired
    RegistrationService registrationService;

    @PostMapping
    public boolean register(@RequestBody RegistrationForm form){
        boolean valid = registrationService.check(form.getLoginCredentials());
        if(valid){
            registrationService.registerLogin(form.getLoginCredentials());
            registrationService.registerProfile(form.getUserProfile());
            registrationService.registerCoords(form.getLoginCredentials().getUsername(), form.getUserProfile().getGender(),form.getCoordinate());
        }
        return valid;
    }

    @GetMapping
    public RegistrationForm testTemplate(){
        LoginCredentials loginCredentials = new LoginCredentials("Meow","Meow@gmail.com","woof");
        Interests interests = new Interests("a","b","c","d","e");
        UserProfile userProfile = new UserProfile("Meow","Cat","1/8/2000","911","Neko Island",interests);
        userProfile.setAge("20");
        Coordinate coordinate = new Coordinate("23.01","24.34");
        return new RegistrationForm(loginCredentials,userProfile,coordinate);
    }
}
