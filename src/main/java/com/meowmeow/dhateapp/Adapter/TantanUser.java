package com.meowmeow.dhateapp.Adapter;

class TantanUser {
    private String username;
    private String birthDate;
    private String gender;
    private String contact;
    private String address;

    public TantanUser(String username, String birthDate, String gender, String contact, String address) {
        this.username = username;
        this.birthDate = birthDate;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
