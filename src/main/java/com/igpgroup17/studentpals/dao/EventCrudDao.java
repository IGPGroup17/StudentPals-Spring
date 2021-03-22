package com.igpgroup17.studentpals.dao;
import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.Student;

public interface EventCrudDao {
    Event createEvent(Event event);
    Event readEvent(String eventId);
    Student addStudent(Student student);
    Student addInterestedStudent(Student student);
    Event updateEvent(Event event);
    void deleteEvent(String eventId);
}
