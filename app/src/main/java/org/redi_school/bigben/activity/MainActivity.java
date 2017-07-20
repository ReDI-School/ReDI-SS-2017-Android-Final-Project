package org.redi_school.bigben.activity;

import org.redi_school.bigben.R;
import org.redi_school.bigben.api.AuthenticatedRestClient;
import org.redi_school.bigben.api.EventService;
import org.redi_school.bigben.data.UserInfo;
import org.redi_school.bigben.entities.Event;
import org.redi_school.bigben.entities.UserData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int USER_COUNT = 10;
    private static final int EVENT_COUNT = 5;
    AuthenticatedRestClient authenticatedRestClient;
    List<Event> userEvents = new ArrayList<>();
    //EventService eventService;

    private List<Event> events = new ArrayList<Event>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If user is not logged in, go to log in
        if (UserInfo.getCurrentUser(this) == null) {
            startActivity(new Intent(this, SignInActivity.class));
            return;
        }
        authenticatedRestClient  = AuthenticatedRestClient
                .getInstance(getApplicationContext());

        initializeServices();

        setContentView(R.layout.activity_main);
        //createEvent();
        getEvent();
        //getEvents();
    }

    private void initializeServices() {
      //  eventService = authenticatedRestClient.createService(EventService.class);
    }

    private void createEvent(){
        final EventService eventService = authenticatedRestClient.createService(EventService.class);
        Event event = new Event(UserInfo.getCurrentUser(MainActivity.this).getId(), "test event", "Redi school", new Date());
        eventService.createEvent(event).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Event created", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }


    private void getEvent() {
        final EventService eventService = authenticatedRestClient.createService(EventService.class);

        eventService.getEvent("5649050225344512").enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                if (response.isSuccessful()){
                    Event event = response.body();
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                int x = 0;
            }
        });
    }

    private void getEvents(){
        AuthenticatedRestClient authenticatedRestClient = AuthenticatedRestClient.getInstance(getApplicationContext());
        final EventService eventService = authenticatedRestClient.createService(EventService.class);
        eventService.getEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()){
                    events.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });



    }

/*
    private List<Event> setupSampleEvents(List<UserData> sampleUsers) {
        List<Event> events = new ArrayList<>();

        GregorianCalendar dateTime = new GregorianCalendar(2017, Calendar.JULY, 6, 20, 44 );

        // create sample events...
        for (int eventIndex = 0; eventIndex < EVENT_COUNT; eventIndex++){
            Event event = new Event();
            event.setOwner(sampleUsers.get(eventIndex));
            event.setName("Event " + ( eventIndex + 1 ) );
            event.setPlace("Place " + ( eventIndex + 1 ) );
            //event.setDate(dateTime);

            events.add(event);
        }

        return events;
    }
*/

}
