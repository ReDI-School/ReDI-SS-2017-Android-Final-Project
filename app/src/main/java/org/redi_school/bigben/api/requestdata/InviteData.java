package org.redi_school.bigben.api.requestdata;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 13/07/2017.
 */

public class InviteData {
    @SerializedName("recepient_id")
    Long receipientId;

    @SerializedName("recepient_email")
    String receipientEmail;

    @SerializedName("event_id")
    Long eventId;

    public InviteData(String receipientEmail, Long eventId) {
        this.receipientEmail = receipientEmail;
        this.eventId = eventId;
    }
}
