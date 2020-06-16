package com.meowmeow.dhateapp.Adapter;

import com.meowmeow.dhateapp.Profile.UserProfile;
import com.meowmeow.dhateapp.Registration.LoginCredentials;
import com.meowmeow.dhateapp.Registration.RegistrationForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adapter")
@CrossOrigin("*")
public class AdapterHandler {
    private TinderAPIreply tinderSample;
    private TantanUser tantanSample = new TantanUser("Meow","2000-08-01T00:00:00.000Z","M","601999999999","420, Purragon Alley, Meowntain View, Catlifornia 94035 ");

    @GetMapping("/tinder")
    public TinderAPIreply testTemplateTinder(){
        return tinderSample;
    }

    @GetMapping("/tantan")
    public TantanUser testTemplateTantan(){
        return tantanSample;
    }

    @PostMapping("/tinder")
    public RegistrationForm registerTinder(@RequestBody TinderAPIreply tinderAPIreply){
        tinderSample = tinderAPIreply;
        TinderUser tinderUser = tinderAPIreply.getData().getUser();
        LoginCredentials loginCredentials = new LoginCredentials();
        UserProfile userProfile = new UserProfile();
        // Birth Date
        String[] temp = tinderUser.getBirth_date().split("T")[0].split("-");
        userProfile.setBirthDate(temp[2]+"/"+temp[1]+"/"+temp[0]);
        // Gender
        userProfile.setGender(tinderUser.getGender()==0?"Male":"Female");
        // Username
        userProfile.setUsername(tinderUser.getName());
        loginCredentials.setUsername(tinderUser.getName());
        // Contact
        userProfile.setContact(tinderUser.getPhone_id());
        // Return prefilled form (left email, password, address, interest)
        return new RegistrationForm(loginCredentials, userProfile,null);
    }

    @PostMapping("/tantan")
    public RegistrationForm registerTantan(@RequestBody TantanUser tantanUser){
        LoginCredentials loginCredentials = new LoginCredentials();
        UserProfile userProfile = new UserProfile();
        //Username
        loginCredentials.setUsername(tantanUser.getUsername());
        userProfile.setUsername(tantanUser.getUsername());
        // Birth Date
        String[] temp = tantanUser.getBirthDate().split("T")[0].split("-");
        userProfile.setBirthDate(temp[2]+"/"+temp[1]+"/"+temp[0]);
        // Gender
        userProfile.setGender(tantanUser.getGender().equalsIgnoreCase("M")?"Male":"Female");
        // Contact
        userProfile.setContact(tantanUser.getContact());
        // Address
        userProfile.setAddress(tantanUser.getAddress());
        // Return prefilled form (left email, password, interest)
        return new RegistrationForm(loginCredentials,userProfile,null);
    }
}
