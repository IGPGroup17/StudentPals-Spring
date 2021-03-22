package com.igpgroup17.studentpals.services.impl;

import com.igpgroup17.studentpals.dao.EventCrudDao;
import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final EventCrudDao eventCrudDao;

    @Autowired
    public EventServiceImpl(EventCrudDao eventCrudDao) {
        this.eventCrudDao = eventCrudDao;
    }

    @Override
    public Event createEvent(Event event) {
        return eventCrudDao.createEvent(event);
    }

    @Override
    public Student addStudent(Student student) {return this.eventCrudDao.addStudent(student); }

    @Override
    public String removeStudent(String studentId) {
        eventCrudDao.removeStudent(studentId);
        return "Removed student from event";
    }

    @Override
    public Student addInterestedStudent(Student student) {return this.eventCrudDao.addInterestedStudent(student); }

    @Override
    public String removeInterestedStudent(String studentId) {
        eventCrudDao.removeInterestedStudent(studentId);
        return "Removed interested student from event";
    }

    @Override
    public Event readEvent(String id) {
        return eventCrudDao.readEvent(id);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventCrudDao.updateEvent(event);
    }

    @Override
    public String deleteEvent(String id) {
        eventCrudDao.deleteEvent(id);
        return "Deleted event";
    }
}
