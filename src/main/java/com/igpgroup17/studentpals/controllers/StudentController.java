package com.igpgroup17.studentpals.controllers;

import com.igpgroup17.studentpals.models.Student;
import com.igpgroup17.studentpals.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/v1/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(studentService.readStudent(id));
    }

    @PostMapping("/v1/students")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PutMapping("/v1/students")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping("/v1/students/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping
    public ResponseEntity<?> getLikedEvents(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(studentService.getLikedEvents(id));
    }
}
