package com.meowmeow.dhateapp.Search;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private String lat;
    private String lon;

    public Coordinate(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
