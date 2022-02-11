package com.yintaowang.assignment.restapi.repository.impl;

import com.yintaowang.assignment.restapi.config.DBConfiguration;
import com.yintaowang.assignment.restapi.domain.entity.Course;
import com.yintaowang.assignment.restapi.domain.entity.Student;
import com.yintaowang.assignment.restapi.domain.entity.Student_Course;
import com.yintaowang.assignment.restapi.repository.StudentCourseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class StudentCourseRepositoryImpl implements StudentCourseRepository {

    EntityManager entityManager = DBConfiguration.getEntityManager();

    @Override
    public int createStudentCourse(int studentId, int courseId) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);
        Student_Course studentCourse = new Student_Course();
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        entityManager.persist(studentCourse);
        tx.commit();
        return 0;
    }
}
