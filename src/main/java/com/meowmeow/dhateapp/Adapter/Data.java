package com.meowmeow.dhateapp.Adapter;

class Data {
    private TinderUser user;

    public Data(){}
    public Data(TinderUser user) {
        this.user = user;
    }

    public void setUser(TinderUser user) {
        this.user = user;
    }

    public TinderUser getUser() {
        return user;
    }
}
