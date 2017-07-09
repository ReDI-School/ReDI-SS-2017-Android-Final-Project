package org.redi_school.bigben.entities;

/**
 * Created by mlu on 06.07.2017.
 */

public class UserDataBuilder {
    private String email;
    private String name;
    private String username;
    private String picture;
    private float punctuality;
    private String subject_id;
    private String provider; // Google or facebook
    private String type; // user or admin

    public UserData build(){
        UserData userData = new UserData();
        userData.setEmail(this.email);
        userData.setName(this.name);
        //...
        return userData;
    }

    public UserDataBuilder addEmail(String email){
        this.email = email;
        return this;
    }

    public UserDataBuilder addName(String name){
        this.name = name;
        return this;
    }
}
