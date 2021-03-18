package com.igpgroup17.studentpals.dao;
import com.igpgroup17.studentpals.models.Event;

public interface EventCrudDao {
    Event createEvent(Event event);
    Event readEvent(String eventId);
    Event updateEvent(Event event);
    void deleteEvent(String eventId);
}
