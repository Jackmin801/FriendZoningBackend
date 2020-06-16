package com.meowmeow.dhateapp.Profile;

import java.io.Serializable;

public class Interests implements Serializable {
    private String sport;
    private String music;
    private String food;
    private String movie;
    private String book;

    public Interests(){}
    public Interests(String sport, String music, String food, String movie, String book) {
        this.sport = sport;
        this.music = music;
        this.food = food;
        this.movie = movie;
        this.book = book;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
