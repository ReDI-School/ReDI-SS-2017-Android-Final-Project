package org.redi_school.bigben.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.redi_school.bigben.entities.Event;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 21.07.17.
 */
public class EventListDeserializer  implements JsonDeserializer<List<Event>> {

    @Override
    public List<Event> deserialize(JsonElement json,
                                   Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
        List<Event> events = new ArrayList<>();

        JsonArray usersJson = json.getAsJsonObject()
                .getAsJsonObject("_embedded")
                .getAsJsonArray("events");

        for (JsonElement userJson :
                usersJson) {
            JsonObject object = userJson.getAsJsonObject();

            final String name = object.getAsJsonPrimitive("name").getAsString();
            final String  owner = object.getAsJsonPrimitive("age").getAsString();
            final String place = object.getAsJsonPrimitive("subject").getAsString();
            final String date = object.getAsJsonPrimitive("subject").getAsString();
            events.add(new Event(name,owner, place, date));
        }
        return events;
    }
}
