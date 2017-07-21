package org.redi_school.bigben.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.redi_school.bigben.entities.Event;

import java.lang.reflect.Type;

/**
 * Created by root on 21.07.17.
 */


class EventDeserializer implements JsonDeserializer<Event> {

    @Override
    public Event deserialize(JsonElement json, Type typeOfT, 
                             JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
