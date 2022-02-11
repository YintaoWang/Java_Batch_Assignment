package com.yintaowang.assignment.restapi.service;

import com.yintaowang.assignment.restapi.domain.dto.CourseResponseDTO;
import com.yintaowang.assignment.restapi.domain.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    int createCourse(Course course);//ok
    int updateCourseById(int id, Course course);
    CourseResponseDTO findCourseById(int id);
    List<CourseResponseDTO> findAllCourse();
    int deleteCourseById(int id);
    int deleteAllCourse();
}
