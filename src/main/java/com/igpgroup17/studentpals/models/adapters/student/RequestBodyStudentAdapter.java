package com.igpgroup17.studentpals.models.adapters.student;

import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.models.requestbody.RequestBodyStudent;

public class RequestBodyStudentAdapter {

    public Student toStudent(RequestBodyStudent student) {
        return Student.builder().build();
    }
}
