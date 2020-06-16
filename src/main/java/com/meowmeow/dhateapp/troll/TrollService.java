package com.meowmeow.dhateapp.troll;

import org.springframework.stereotype.Service;

@Service
public class TrollService {

    public String trollify(String text){
        return uwuify(text);
    }

    private String uwuify(String text){
        text = text.replaceAll("th","f");
        text = text.replaceAll("TH", "F");
        text = text.replaceAll("l","w");
        text = text.replaceAll("r","w");
        text = text.replaceAll("L","W");
        text = text.replaceAll("R","W");
        text = text.replaceAll("N","Ny");
        text = text.replaceAll("n","ny");
        return text+" uwu";
    }
}
