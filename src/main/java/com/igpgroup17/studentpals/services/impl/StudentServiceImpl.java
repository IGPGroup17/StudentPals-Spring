package com.igpgroup17.studentpals.services.impl;

import com.igpgroup17.studentpals.dao.StudentCrudDao;
import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.EventPreview;
import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.models.adapters.event.EventPreviewAdapter;
import com.igpgroup17.studentpals.services.EventService;
import com.igpgroup17.studentpals.services.StudentService;
import com.igpgroup17.studentpals.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentCrudDao studentCrudDao;

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
        return studentCrudDao.readStudent(id).getInterestedEvents().stream()
                .map(eventService::readEvent)
                .map(EventPreviewAdapter::adapt)
                .collect(Collectors.toList());
    }

    @Override
    public Event addLike(String studentId, String eventId) {
        Student student = studentCrudDao.readStudent(studentId);
        Event event = eventService.readEvent(eventId);

        List<String> likedEvents = ListUtils.copyOf(student.getInterestedEvents());
        List<String> interestedUsers = ListUtils.copyOf(event.getInterestedUsersIDs());

        likedEvents.add(eventId);
        interestedUsers.add(studentId);

        student.setInterestedEvents(likedEvents);
        event.setInterestedUsersIDs(interestedUsers);

        eventService.updateEvent(event);
        studentCrudDao.updateStudent(student);
        return null;
    }
}
