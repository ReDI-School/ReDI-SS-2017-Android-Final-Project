package org.redi_school.bigben.http;

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

/**
 * Created by mlu on 09.07.2017.
 */

public interface ApiService {

    static final String AUTHORIZATION = "Authorization";

    @POST("/authenticate")
    UserData authenticate(@Body Task task);

    @GET("/events")
    Call<List<Event>> getEvents(@Header(AUTHORIZATION) String authorization);

    @GET("/events/{eventID}")
    Call<Event> getEvent(@Header(AUTHORIZATION) String authorization, @Path("eventID") String eventID);

    @POST("/events")
    Call<Void> createEvent(@Header(AUTHORIZATION) String authorization, @Body Event event);

    @POST("/events/{eventID}")
    Call<Void> userUpdateToEvent(@Header(AUTHORIZATION) String authorization, @Path("eventID") String eventID, @Body Event event);

    @DELETE("/events/{eventID}")
    Call<Void> deleteEvent(@Header(AUTHORIZATION) String authorization, @Path("eventID") String eventID);

    @GET("/users")
    Call<List<UserData>> getUsers(@Header(AUTHORIZATION) String authorization);
}
