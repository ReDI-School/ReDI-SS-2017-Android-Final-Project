package org.redi_school.bigben;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.redi_school.bigben.entities.Event;
import org.redi_school.bigben.entities.UserData;
import org.redi_school.bigben.entities.UserDataBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int USER_COUNT = 10;
    private static final int EVENT_COUNT = 5;

    private List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSampleData();

        // Recycler View...
    }

    private void setupSampleData() {
        List<UserData> sampleUsers = setupSampleUsers();
        events = setupSampleEvents(sampleUsers);
    }

    private List<Event> setupSampleEvents(List<UserData> sampleUsers) {
        List<Event> events = new ArrayList<>();

        GregorianCalendar dateTime = new GregorianCalendar(2017, Calendar.JULY, 6, 20, 44 );

        // create sample events...
        for (int eventIndex = 0; eventIndex < EVENT_COUNT; eventIndex++){
            Event event = new Event();
            event.setOwner(sampleUsers.get(eventIndex));
            event.setName("Event " + ( eventIndex + 1 ) );
            event.setPlace("Place " + ( eventIndex + 1 ) );
            event.setDate(dateTime);

            events.add(event);
        }

        return events;
    }

    private List<UserData> setupSampleUsers() {

        List<UserData> userDataList = new ArrayList<>();
        for (int userIndex = 0; userIndex < USER_COUNT; userIndex++ ){

            String email = "user" + ( userIndex + 1 ) + "@gmail.com";
            String name = "user" + ( userIndex + 1 );
            UserData userData = new UserDataBuilder()
                    .addEmail(email)
                    .addName(name)
                    .build();

            userDataList.add(userData);

        }
        return userDataList;
    }
}
