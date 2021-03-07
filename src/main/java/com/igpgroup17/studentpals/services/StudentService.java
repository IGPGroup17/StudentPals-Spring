package com.igpgroup17.studentpals.services;


import com.igpgroup17.studentpals.models.Student;

public interface StudentService {

    Student createStudent(Student student);

    Student readStudent(String id);

    Student updateStudent(Student student);

    String deleteStudent(String id);
}
