package org.redi_school.bigben.entities;

import java.util.GregorianCalendar;

/**
 * Created by mlu on 06.07.2017.
 */

public class Event {

    private UserData owner;
    private String name;
    private String place;
    private GregorianCalendar date;

    public void setOwner(UserData owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
