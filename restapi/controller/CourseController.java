package com.yintaowang.assignment.restapi.controller;

import com.yintaowang.assignment.restapi.domain.dto.CourseResponseDTO;
import com.yintaowang.assignment.restapi.domain.entity.Course;
import com.yintaowang.assignment.restapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public int postCourse(){
//    public int postCourse(@RequestBody Course course){
        Course course=new Course();//just for test
        course.setName("Algorithm");//just for test
        return courseService.createCourse(course);
    }

    @PutMapping("/courses/{id}")
    public int putCourseById(@PathVariable int id){
        //TODO
        return 0;
    }

    @GetMapping("/courses/{id}")
    public CourseResponseDTO getCourseById(@PathVariable int id){
        //TODO
        return null;
    }

    @GetMapping("/courses")
    public List<CourseResponseDTO> getAllCourses(){
        //TODO
        return null;
    }
}
