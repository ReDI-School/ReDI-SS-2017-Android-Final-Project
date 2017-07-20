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
    private Long owner;
    private String name;
    private String place;
    private Date time;
    private Date creeated;


    @SerializedName("attendees_status")
    private List<AttendeeStatus> attendeeStatuses;

    public Event(Long owner, String name, String place,Date time ) {
        this.owner = owner;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setOwner(Long owner) {

        this.owner = owner;
    }
}
