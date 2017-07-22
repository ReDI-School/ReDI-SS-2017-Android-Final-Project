package org.redi_school.bigben.entities;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mlu on 06.07.2017.
 */

public class Event {

    private Long id;
    private String owner;
    private String name;
    private String place;
    private Date time;
    private Date creeated;


    @SerializedName("attendees_status")
    private List<AttendeeStatus> attendeeStatuses;

    public Event(){}

    public Event(String name, String place, Date time) {
        this.name = name;
        this.place = place;
        this.time = time;
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

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public Date getTime() {
        return time;
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
