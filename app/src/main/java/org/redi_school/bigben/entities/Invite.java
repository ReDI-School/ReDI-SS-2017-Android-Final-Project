package org.redi_school.bigben.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by admin on 13/07/2017.
 */

public class Invite {

    private Long id;
    private Long receipnt_id;
    private State state;
    private GregorianCalendar modified;
    private Long sender_id;
    private Long event_id;

    enum State{

        @SerializedName("pending")
        PENDING,

        @SerializedName("accepted")
        ACCEPTED,

        @SerializedName("rejected")
        REJECTED;
    }
}
