package com.meowmeow.dhateapp.Registration;

import com.meowmeow.dhateapp.Profile.UserProfile;
import com.meowmeow.dhateapp.Search.Coordinate;

public class RegistrationForm {
    private UserProfile userProfile;
    private LoginCredentials loginCredentials;
    private Coordinate coordinate;

    public RegistrationForm(){}
    public RegistrationForm(LoginCredentials loginCredentials, UserProfile userProfile, Coordinate coordinate) {
        this.userProfile = userProfile;
        this.loginCredentials = loginCredentials;
        this.coordinate = coordinate;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public LoginCredentials getLoginCredentials() {
        return loginCredentials;
    }

    public void setLoginCredentials(LoginCredentials loginCredentials) {
        this.loginCredentials = loginCredentials;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
