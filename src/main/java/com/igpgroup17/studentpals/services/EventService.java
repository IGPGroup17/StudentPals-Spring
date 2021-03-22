package com.igpgroup17.studentpals.services;
import com.igpgroup17.studentpals.models.Event;

public interface EventService {

    Event createEvent(Event event);

    Event readEvent(String id);

    Event updateEvent(Event event);

    String deleteEvent(String id);
}
