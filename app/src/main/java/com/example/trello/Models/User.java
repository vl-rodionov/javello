package com.example.trello.Models;

import com.example.trello.Data.DataManager.Gender;

public class User {

    private String firstname;
    private String lastname;
    private String email;
    private Gender gender;
    private String userID;

    public User(String firstname, String lastname, String email, String userID, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.userID = userID;
        this.gender = gender;
    }

    public User(String firstname, String lastname, String email, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;

    }

    public User() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return firstname + " " + lastname;
    }
}
