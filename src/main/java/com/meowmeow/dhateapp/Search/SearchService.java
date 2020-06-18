package com.meowmeow.dhateapp.Search;

import com.meowmeow.dhateapp.Profile.Interests;
import com.meowmeow.dhateapp.Profile.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {
    private final double R=6371;

    @Autowired
    @Qualifier("UserTemplate")
    RedisTemplate<String,Object> redisTemplate;

    private double distance(RadCoordinate a, RadCoordinate b){
        //Haversine Formula
        double da = a.getLat() - b.getLat();
        double db = a.getLon() - b.getLon();
        double A = Math.pow(Math.sin(da/2),2) + Math.pow(Math.sin(db/2),2)*Math.cos(a.getLat())*Math.cos(b.getLat());
        double C = 2*Math.atan2(Math.sqrt(A), Math.sqrt(1-A));
        return R*C;
    }

    private int match(Interests a, Interests b){
        int ret =0;
        if(a.getSport().equalsIgnoreCase(b.getSport()))ret++;
        if(a.getMusic().equalsIgnoreCase(b.getMusic()))ret++;
        if(a.getFood().equalsIgnoreCase(b.getFood()))ret++;
        if(a.getMovie().equalsIgnoreCase(b.getMovie()))ret++;
        if(a.getBook().equalsIgnoreCase(b.getBook()))ret++;
        return ret;
    }

    private RadCoordinate convertToRad(Coordinate coord){
        return new RadCoordinate(Double.valueOf(coord.getLat())*Math.PI/180,Double.valueOf(coord.getLon())*Math.PI/180);
    }

    private ArrayList<SearchResult> searchList(Coordinate coord, int dist, String username, String gender){
        //Convert coordinate to radian
        RadCoordinate radcoord = convertToRad(coord);
        //Get users of this gender
        Map<Object, Object> userCoords = redisTemplate.opsForHash().entries("COORD"+gender);
        ArrayList<SearchResult> ret = new ArrayList<>();
        for (Object i:userCoords.keySet()) {
            //If its the same person dont match lol
            // USE EQUALS!!!
            if(username.equalsIgnoreCase(i.toString()))continue;
            //Find distance
            int distance = (int)(Math.floor(distance(radcoord,(RadCoordinate) userCoords.get(i))*10));
            //Add to list if in search radius
            if(distance < dist){
                ret.add(new SearchResult((String)i,distance,0));
            }
        }
        return ret;
    }

    public List<SearchResult> search(Coordinate coord, int dist, String username, String gender) {
        ArrayList<SearchResult> ret;
        //Get result
        if(gender.equalsIgnoreCase("Both")){
            ret = searchList(coord, dist, username, "Male");
            ret.addAll(searchList(coord, dist, username, "Female"));
        }else{
            ret = searchList(coord, dist, username, gender);
        }
        //Find ops interest
        UserProfile a = (UserProfile)redisTemplate.opsForHash().get(username, "profile");
        //Find Match
        for (SearchResult i: ret) {
            UserProfile b = (UserProfile)redisTemplate.opsForHash().get(i.getUsername(),"profile");
            i.setMatch(match(a.getInterests(),b.getInterests()));
        }
        //Sort
        Collections.sort(ret);
        return ret;
    }

    public List<SearchResult> search(String username, int dist,String gender){
        Coordinate a = (Coordinate)redisTemplate.opsForHash().get(username,"coord");
        return search(a,dist,username,gender);
    }


}
