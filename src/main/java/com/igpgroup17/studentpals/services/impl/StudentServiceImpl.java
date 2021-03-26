package com.igpgroup17.studentpals.services.impl;

import com.igpgroup17.studentpals.dao.StudentCrudDao;
import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.EventPreview;
import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.models.adapters.event.EventPreviewAdapter;
import com.igpgroup17.studentpals.services.EventService;
import com.igpgroup17.studentpals.services.StudentService;
import com.igpgroup17.studentpals.util.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentCrudDao studentCrudDao;

    private final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final EventService eventService;

    @Autowired
    public StudentServiceImpl(StudentCrudDao studentCrudDao, EventService eventService) {
        this.studentCrudDao = studentCrudDao;
        this.eventService = eventService;
    }

    @Override
    public Student createStudent(Student student) {
        return studentCrudDao.createStudent(student);
    }

    @Override
    public Student readStudent(String id) {
        return studentCrudDao.readStudent(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentCrudDao.updateStudent(student);
    }

    @Override
    public String deleteStudent(String id) {
        studentCrudDao.deleteStudent(id);
        return "Deleted student";
    }

    // very inefficient - use batch requests later
    @Override
    public List<EventPreview> getLikedEvents(String id) {
        List<Event> events = studentCrudDao.readStudent(id).getLikedEvents().stream()
                .map(eventService::readEvent).collect(Collectors.toList());

        LOGGER.info(events.stream().map(Event::getEventID).collect(Collectors.joining(", ")));
        return events.stream().map(EventPreviewAdapter::adapt)
                .collect(Collectors.toList());
    }

    @Override
    public Event addLike(String studentId, String eventId) {
        Student student = studentCrudDao.readStudent(studentId);

        List<String> likedEvents = ListUtils.copyOf(student.getLikedEvents());

        likedEvents.add(eventId);

        student.setLikedEvents(likedEvents);

        LOGGER.info(student.getLikedEvents().stream().collect(Collectors.joining(", ")));

        studentCrudDao.updateStudent(student);
        return eventService.readEvent(eventId);
    }

    @Override
    public List<EventPreview> getGoingEvents(String id) {
        return studentCrudDao.readStudent(id).getGoingEvents().stream()
                .map(eventService::readEvent)
                .map(EventPreviewAdapter::adapt)
                .collect(Collectors.toList());
    }

    @Override
    public Event addGoing(String studentId, String eventId) {
        Student student = studentCrudDao.readStudent(studentId);
        Event event = eventService.readEvent(eventId);

        List<String> goingEvents = ListUtils.copyOf(student.getGoingEvents());
        List<String> goingUsersIDs = ListUtils.copyOf(event.getGoingUsersIDs());

        goingEvents.add(eventId);
        goingUsersIDs.add(studentId);

        student.setGoingEvents(goingEvents);
        event.setGoingUsersIDs(goingUsersIDs);

        eventService.updateEvent(event);
        studentCrudDao.updateStudent(student);
        return event;
    }

    @Override
    public List<EventPreview> getInterestedEvents(String id) {
        return studentCrudDao.readStudent(id).getLikedEvents().stream()
                .map(eventService::readEvent)
                .map(EventPreviewAdapter::adapt)
                .collect(Collectors.toList());
    }

    @Override
    public Event addInterested(String studentId, String eventId) {
        Student student = studentCrudDao.readStudent(studentId);
        Event event = eventService.readEvent(eventId);

        List<String> interestedEvents = ListUtils.copyOf(student.getInterestedEvents());
        List<String> interestedUsers = ListUtils.copyOf(event.getInterestedUsersIDs());

        interestedEvents.add(eventId);
        interestedUsers.add(studentId);

        student.setInterestedEvents(interestedEvents);
        event.setInterestedUsersIDs(interestedUsers);

        eventService.updateEvent(event);
        studentCrudDao.updateStudent(student);
        return event;
    }
}
