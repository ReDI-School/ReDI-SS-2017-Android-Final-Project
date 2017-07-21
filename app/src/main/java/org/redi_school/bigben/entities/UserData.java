package org.redi_school.bigben.entities;

/**
 * Created by mlu on 06.07.2017.
 */

public class UserData {
    private Long id;
    private String token;
    private String email;
    private String name;
    private String username;
    private String picture;
    private float punctuality;
    private String subject_id;
    private String provider; // Google or facebook
    private String type; // user or admin

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }


}
