package com.igpgroup17.studentpals.services.impl;

import com.igpgroup17.studentpals.dao.StudentCrudDao;
import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentCrudDao studentCrudDao;

    @Autowired
    public StudentServiceImpl(StudentCrudDao studentCrudDao) {
        this.studentCrudDao = studentCrudDao;
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
}
