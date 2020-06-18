package com.meowmeow.dhateapp;

import com.meowmeow.dhateapp.Encryption.Encryption;
import com.meowmeow.dhateapp.Encryption.Key;
import com.meowmeow.dhateapp.Encryption.TeaEncryption;
import com.meowmeow.dhateapp.Encryption.TeaKey;
import com.meowmeow.dhateapp.Troll.TrollService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Encryption test = new TeaEncryption();
        String a = "Hello world meow meow beep beep i  am dog";
        Key key = new TeaKey();
        a=test.encrypt(a,key);
        System.out.println(a);
        a=test.decrypt(a,key);
        System.out.println(a);



    }
}
