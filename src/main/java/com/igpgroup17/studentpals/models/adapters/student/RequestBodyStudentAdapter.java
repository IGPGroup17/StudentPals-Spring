package com.igpgroup17.studentpals.models.adapters.student;

import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.models.requestbody.RequestBodyStudent;

import java.util.ArrayList;
import java.util.UUID;

public class RequestBodyStudentAdapter {

    public Student toStudent(RequestBodyStudent student) {
        return Student.builder()
                .studentId(UUID.randomUUID().toString())
                .realName(student.getRealName())
                .username(student.getUsername())
                .email(student.getEmail())
                .age(student.getAge())
                .gender(student.getGender())
                .universityName(student.getUniversityName())
                .universityEmail(student.getUniversityEmail())
                .course(student.getCourse())
                .interestedEvents(new ArrayList<>())
                .build();
    }
}
