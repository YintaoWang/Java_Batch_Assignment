package com.yintaowang.assignment.restapi.repository.impl;

import com.yintaowang.assignment.restapi.config.DBConfiguration;
import com.yintaowang.assignment.restapi.domain.entity.Course;
import com.yintaowang.assignment.restapi.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    EntityManager entityManager = DBConfiguration.getEntityManager();

    @Override
    public int createCourse(Course course) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(course);
        tx.commit();
        return 0;
    }

    @Override
    public int updateCourseById(int id, Course course) {
        //TODO
        return 0;
    }

    @Override
    public Course findCourseById(int id) {
        //TODO
        return null;
    }

    @Override
    public List<Course> findAllCourse() {
        //TODO
        return null;
    }

    @Override
    public int deleteCourseByIdWithOrphanRemove(int id) {
        //TODO
        return 0;
    }

    @Override
    public int deleteCourseByIdWithoutOrphanRemove(int id) {
        //TODO
        return 0;
    }

    @Override
    public int deleteAllCourse() {
        //TODO
        return 0;
    }
}
