package com.yintaowang.assignment.restapi.service;

import org.springframework.stereotype.Service;

@Service
public interface StudentCourseService {
    int createStudentCourse(int studentId, int courseId);
}
