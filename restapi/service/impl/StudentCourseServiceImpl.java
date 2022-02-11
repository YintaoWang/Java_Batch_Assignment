package com.yintaowang.assignment.restapi.service.impl;

import com.yintaowang.assignment.restapi.repository.StudentCourseRepository;
import com.yintaowang.assignment.restapi.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public int createStudentCourse(int studentId, int courseId) {
        return studentCourseRepository.createStudentCourse(studentId, courseId);
    }
}
