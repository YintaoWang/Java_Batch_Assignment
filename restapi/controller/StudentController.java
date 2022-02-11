package com.yintaowang.assignment.restapi.controller;

import com.yintaowang.assignment.restapi.domain.dto.StudentResponseDTO;
import com.yintaowang.assignment.restapi.domain.entity.Student;
import com.yintaowang.assignment.restapi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public int postStudent() {
//    public int postStudent(@RequestBody Student student){
        log.trace("post new student...");
        Student student = new Student(); //just for test
        student.setName("Cindy"); //just for test
        return studentService.createStudent(student);
    }

    @PutMapping("/students/{id}")
    public int putStudentById(@PathVariable int id) {
//    public int putStudentById(@PathVariable int id, @RequestBody Student student){
        log.trace("update student by id.");
        Student student = new Student(); //just for test
        student.setName("Sara"); //just for test
        return studentService.updateStudentById(id, student);
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO getStudentById(@PathVariable int id) {
        log.trace("retrieve student by id.");
        return studentService.findStudentById(id);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        log.trace("retrieve all the students.");
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }
}
