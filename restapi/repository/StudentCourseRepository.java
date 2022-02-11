package com.yintaowang.assignment.restapi.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository {
    int createStudentCourse(int studentId, int courseId); //student register a course
}
