package com.meowmeow.dhateapp.Search;

public class SearchResult implements Comparable<SearchResult> {
    private String username;
    private int distance;
    private int match;

    public SearchResult(String username, int distance, int match) {
        this.username = username;
        this.distance = distance;
        this.match = match;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    @Override
    public int compareTo(SearchResult o) {
        if(this.match < o.match) return 1;
        if(this.match > o.match) return -1;
        return 0;
    }
}
