package org.redi_school.bigben.entities;

/**
 * Created by mlu on 06.07.2017.
 */

public class UserData {
    private String email;
    private String name;
    private String username;
    private String picture;
    private float punctuality;
    private String subject_id;
    private String provider; // Google or facebook
    private String type; // user or admin

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPunctuality(float punctuality) {
        this.punctuality = punctuality;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setType(String type) {
        this.type = type;
    }
}
