package com.igpgroup17.studentpals.services;
import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.Student;

public interface EventService {

    Event createEvent(Event event);

    Event readEvent(String id);

    Student addStudent(Student student);

    String removeStudent(String studentId);

    Student addInterestedStudent(Student student);

    String removeInterestedStudent(String studentId);

    Event updateEvent(Event event);

    String deleteEvent(String id);
}
