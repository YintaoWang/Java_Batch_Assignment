package com.yintaowang.assignment.restapi.repository;

import com.yintaowang.assignment.restapi.domain.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {
    int createCourse(Course course);
    int updateCourseById(int id, Course course);
    Course findCourseById(int id);
    List<Course> findAllCourse();
    int deleteCourseByIdWithOrphanRemove(int id);
    int deleteCourseByIdWithoutOrphanRemove(int id);
    int deleteAllCourse(); // orphan removal?
}
