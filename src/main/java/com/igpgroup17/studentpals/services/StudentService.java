package com.igpgroup17.studentpals.services;


import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.EventPreview;
import com.igpgroup17.studentpals.models.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student readStudent(String id);

    Student updateStudent(Student student);

    String deleteStudent(String id);

    List<EventPreview> getLikedEvents(String id);

    Event addLike(String studentId, String eventId);
}
