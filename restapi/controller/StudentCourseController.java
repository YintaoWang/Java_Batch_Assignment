package com.yintaowang.assignment.restapi.controller;

import com.yintaowang.assignment.restapi.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class StudentCourseController {
    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping("/studentcourse/{studentid}/{courseid}")
    public int postStudentCourseJunction(@PathVariable(name = "studentid") int studentId, @PathVariable(name = "courseid") int courseId){
        return studentCourseService.createStudentCourse(studentId, courseId);
        //TODO: test
    }
}
