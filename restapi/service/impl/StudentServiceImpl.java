package com.yintaowang.assignment.restapi.service.impl;

import com.yintaowang.assignment.restapi.domain.dto.StudentResponseDTO;
import com.yintaowang.assignment.restapi.domain.entity.Student;
import com.yintaowang.assignment.restapi.repository.StudentRepository;
import com.yintaowang.assignment.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public int createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    @Override
    public int updateStudentById(int id, Student student) {
        return studentRepository.updateStudentById(id, student);
    }

    @Override
    public StudentResponseDTO findStudentById(int id) {
        Student student = studentRepository.findStudentById(id);
        return new StudentResponseDTO(student.getId(), student.getName());
    }

    @Override
    public List<StudentResponseDTO> findAllStudents() {
        return studentRepository.findAllStudent()
                .stream()
                .map(s -> new StudentResponseDTO(s.getId(), s.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public int deleteStudentById(int id) {
        //TODO
        return 0;
    }

    @Override
    public int deleteAllStudent() {
        //TODO
        return 0;
    }
}
