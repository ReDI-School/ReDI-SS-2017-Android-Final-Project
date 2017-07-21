package org.redi_school.bigben.activity;

import org.redi_school.bigben.R;
import org.redi_school.bigben.api.AuthenticatedRestClient;
import org.redi_school.bigben.api.EventService;
import org.redi_school.bigben.data.UserInfo;
import org.redi_school.bigben.entities.Event;
import org.redi_school.bigben.entities.UserData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If user is not logged in, go to log in
        if (UserInfo.getCurrentUser(this) == null) {
            startActivity(new Intent(this, SignInActivity.class));
            return;
        }
        authenticatedRestClient = AuthenticatedRestClient
                .getInstance(getApplicationContext());

      //  initializeServices();
        setContentView(R.layout.activity_main);
        createEvent();
        setupShowAllUsersButton();
    }
    
    AuthenticatedRestClient authenticatedRestClient;
    //EventService eventService;

    private List<Event> events = new ArrayList<Event>();
    private Event event=new Event();
    //private void initializeServices() {
      //  EventService eventService = authenticatedRestClient.createService(EventService.class);
    //}

    private void createEvent() {
        final EventService eventService = authenticatedRestClient.createService(EventService.class);
        final AuthenticatedRestClient client = AuthenticatedRestClient.getInstance(this);

        final EditText name_text = (EditText) findViewById(R.id.event_name);

        final EditText subject_text = (EditText) findViewById(R.id.owner_name);


        final EditText location_text = (EditText) findViewById(R.id.location);

        final EditText time_text = (EditText) findViewById(R.id.time);

        final Button showAllUsersButton = (Button) findViewById(R.id.create_event);
        showAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String event_name = name_text.getText().toString();
                final String event_owner = subject_text.getText().toString();
                final String event_location = location_text.getText().toString();
                final String event_time = time_text.getText().toString();


                final Event user = new Event(event_name,event_owner,event_location,event_time);
                eventService.createEvent(event).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "User created", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d(TAG, t.getLocalizedMessage());
                    }
                });
            }
        });


    }

/*
    private Event getEvent() {
        AuthenticatedRestClient authenticatedRestClient = AuthenticatedRestClient.getInstance(getApplicationContext());
        final EventService eventService = authenticatedRestClient.createService(EventService.class);

        eventService.getEvent("5649050225344512").enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                if (response.isSuccessful()) {
                    event = response.body();
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                int x = 0;
            }
        });

        return event;
    }
  */
    private void setupShowAllUsersButton() {
        final Button showAllUsersButton = (Button) findViewById(R.id.show_events);
        showAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShowTheEvents.class));
            }
        });

    }
}


