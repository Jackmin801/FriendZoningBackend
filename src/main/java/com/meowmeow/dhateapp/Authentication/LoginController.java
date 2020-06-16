package com.meowmeow.dhateapp.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private AuthenticateService authenticateService;

    @GetMapping("/{usernameOrEmail}")
    public UUID authenticate(@PathVariable("usernameOrEmail") String usernameOrEmail, @RequestParam("pw") String pw){
        if(usernameOrEmail.indexOf('@')==-1){//Username
            String email = authenticateService.getEmail(usernameOrEmail);
            return authenticateService.auth(email,pw);
        }else{//email
            return authenticateService.auth(usernameOrEmail,pw);
        }
    }

}
