package com.yintaowang.assignment.restapi.repository;

import com.yintaowang.assignment.restapi.domain.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    int createStudent(Student student);
    int updateStudentById(int id, Student student);
    Student findStudentById(int id);
    List<Student> findAllStudent();
    int deleteStudentByIdWithOrphanRemove(int id);
    int deleteStudentByIdWithoutOrphanRemove(int id);
    int deleteAllStudent(); // consider orphan removal???
}
