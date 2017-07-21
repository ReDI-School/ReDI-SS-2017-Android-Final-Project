package org.redi_school.bigben.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by mlu on 06.07.2017.
 */

public class Event {

    private Long id;
    private String owner;
    private String name;
    private String place;
    private String time;
    //private Date time;
    private GregorianCalendar date;
    //private Date creeated;


    @SerializedName("attendees_status")
    private List<AttendeeStatus> attendeeStatuses;

    public Event(){}

    public Event( String name,String owner, String place, String time ) {
        this.owner = owner;
        this.name = name;
        this.place = place;
        this.time = time;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    static public class AttendeeStatus{
        String status;
        Long id;

        @SerializedName("last_location")
        Location lastLocation;

        @SerializedName("user")
        Long userId;
        Date modified;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setOwner(String owner) {

        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {

        return name;
    }

    public String getPlace() {
        return place;
    }

    //public Date getTime() {
    //  return time;
    //}

    //public Date getCreeated() {
    //   return creeated;
    //}

   /* public List<AttendeeStatus> getAttendeeStatuses() {
        return attendeeStatuses;}
    */
}
