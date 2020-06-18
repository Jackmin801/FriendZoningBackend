package com.meowmeow.dhateapp.Troll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

@Service
public class TrollService {
    private HashMap<String, String> evilMappings;

    public TrollService(){
        try{
            Resource resource = new ClassPathResource("evilmaps.ser");;
            ObjectInputStream in = new ObjectInputStream(resource.getInputStream());
            evilMappings = (HashMap<String, String>) in.readObject();
            System.out.println("Banana in the jungle");
        }catch (Exception e){
            evilMappings = new HashMap<>();
            System.out.println("Banana on the roof");
        }
    }

    public String trollify(String text){
        String[] temp = text.split(" ");
        for(int i=0;i<temp.length;i++){ if(evilMappings.containsKey(temp[i]))temp[i]=evilMappings.get(temp[i]); }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<temp.length-1;i++){
            sb.append(temp[i]);
            sb.append(" ");
        }
        sb.append(temp[temp.length-1]);
        text = sb.toString();
        return uwuify(text);
    }

    private String uwuify(String text){
        text = text.replaceAll("th","d");
        text = text.replaceAll("TH", "D");
        text = text.replaceAll("l","w");
        text = text.replaceAll("r","w");
        text = text.replaceAll("L","W");
        text = text.replaceAll("R","W");
        text = text.replaceAll("N","Ny");
        text = text.replaceAll("n","ny");
        text = text.replaceAll("ove","uv");
        text = text.replaceAll("you","yuw");
        return text+" uwu";
    }
}
