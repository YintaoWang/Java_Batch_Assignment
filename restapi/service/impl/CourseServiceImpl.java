package com.yintaowang.assignment.restapi.service.impl;

import com.yintaowang.assignment.restapi.domain.dto.CourseResponseDTO;
import com.yintaowang.assignment.restapi.domain.entity.Course;
import com.yintaowang.assignment.restapi.repository.CourseRepository;
import com.yintaowang.assignment.restapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public int createCourse(Course course) {
        courseRepository.createCourse(course);
        return 0;
    }

    @Override
    public int updateCourseById(int id, Course course) {
        //TODO
        return 0;
    }

    @Override
    public CourseResponseDTO findCourseById(int id) {
        //TODO
        return null;
    }

    @Override
    public List<CourseResponseDTO> findAllCourse() {
        //TODO
        return null;
    }

    @Override
    public int deleteCourseById(int id) {
        //TODO
        return 0;
    }

    @Override
    public int deleteAllCourse() {
        //TODO
        return 0;
    }
}
