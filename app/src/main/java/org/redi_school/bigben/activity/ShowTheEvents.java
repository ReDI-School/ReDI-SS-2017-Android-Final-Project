package org.redi_school.bigben.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.redi_school.bigben.R;
import org.redi_school.bigben.api.AuthenticatedRestClient;
import org.redi_school.bigben.api.EventService;
import org.redi_school.bigben.entities.Event;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTheEvents extends AppCompatActivity {

    private static final String TAG = ShowTheEvents.class.getSimpleName();
    private EventAdapter eventAdapter;
    List<Event> events = new ArrayList<Event>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler_view);
        getEvents();
        setupListOfevents();

    }

    private List<Event> getEvents() {
        AuthenticatedRestClient authenticatedRestClient = AuthenticatedRestClient.getInstance(getApplicationContext());
        final Button showAllUsersButton = (Button) findViewById(R.id.show_events);
        showAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShowTheEvents.this, ShowTheEvents.class));
            }
        });

        final EventService eventService = authenticatedRestClient.createService(EventService.class);
        eventService.getEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    events.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });

        return events;
    }
    private void setupListOfevents(){
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        eventAdapter = new EventAdapter(events);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
