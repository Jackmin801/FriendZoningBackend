package com.meowmeow.dhateapp.Profile;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
public class UserProfile implements Serializable {
    @Id
    private String username;
    private String gender;
    private String age;
    private String birthDate;
    private String contact;
    private String address;
    private Interests interests;

    public UserProfile(){}
    public UserProfile(String username, String gender, String birthDate, String contact, String address, Interests interests) {
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contact = contact;
        this.address = address;
        this.interests = interests;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public Interests getInterests() {
        return interests;
    }

    public void setInterests(Interests interests) {
        this.interests = interests;
    }
}
