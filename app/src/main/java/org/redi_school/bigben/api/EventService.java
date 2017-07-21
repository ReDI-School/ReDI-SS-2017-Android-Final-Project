package org.redi_school.bigben.api;

import com.google.android.gms.tasks.Task;

import org.redi_school.bigben.entities.Event;
import org.redi_school.bigben.entities.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mlu on 09.07.2017.
 */

public interface EventService {


    @GET("/events")
    Call<List<Event>> getEvents();

    @GET("/events/{eventID}")
    Call<Event> getEvent(@Path("eventID") String eventID);

    @POST("/events")
    Call<Void> createEvent(@Body Event event);

    @POST("/events/{eventID}")
    Call<Void> userUpdateToEvent(@Path("eventID") String eventID, @Body Event.AttendeeStatus eventStatus);

    @DELETE("/events/{eventID}")
    Call<Void> deleteEvent(@Path("eventID") String eventID);



}
