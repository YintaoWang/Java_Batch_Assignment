package com.yintaowang.assignment.restapi.service;

import com.yintaowang.assignment.restapi.domain.dto.StudentResponseDTO;
import com.yintaowang.assignment.restapi.domain.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    int createStudent(Student student); //ok
    int updateStudentById(int id, Student student); //ok
    StudentResponseDTO findStudentById(int id); //ok
    List<StudentResponseDTO> findAllStudents(); //ok
    int deleteStudentById(int id);
    int deleteAllStudent();

}
