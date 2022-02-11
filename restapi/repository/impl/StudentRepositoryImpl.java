package com.yintaowang.assignment.restapi.repository.impl;

import com.yintaowang.assignment.restapi.config.DBConfiguration;
import com.yintaowang.assignment.restapi.domain.entity.Student;
import com.yintaowang.assignment.restapi.domain.entity.Student_Course;
import com.yintaowang.assignment.restapi.exception.RecordsNotFindException;
import com.yintaowang.assignment.restapi.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private EntityManager entityManager = DBConfiguration.getEntityManager();

    @Override
    public int createStudent(Student student) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(student);
        tx.commit();
        return 0;
    }

    @Override
    public int updateStudentById(int id, Student student) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Student studentToBeUpdate = entityManager.find(Student.class, id);
        studentToBeUpdate.setName(student.getName());
        entityManager.persist(studentToBeUpdate);

        //either way works
//        Query query = entityManager.createNativeQuery("update student set name=? where id=? ");
//        query.setParameter(1, student.getName());
//        query.setParameter(2, id);
//        query.executeUpdate();
        tx.commit();
        return 0;
    }

    @Override
    public Student findStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        if(student == null) throw new RecordsNotFindException(); //works
        return student;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> studentList = (List<Student>) entityManager.createQuery("select s from Student s").getResultList();
        System.out.println(studentList);
        return studentList;
    }

    @Override
    public int deleteStudentByIdWithOrphanRemove(int id) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Query query = entityManager.createQuery("select s from Student s join fetch s.studentCourseList sc where s.id=?1");
        query.setParameter(1, id);
        Student student = (Student) query.getSingleResult();
        Iterator<Student_Course> itr = student.getStudentCourseList().iterator();
        while (itr.hasNext()) {
            Student_Course sc = itr.next();
            if (sc.getStudent().getId() == id) {
                itr.remove();
            }
        }
        tx.commit();
        return 0;
    }

    @Override
    public int deleteStudentByIdWithoutOrphanRemove(int id) {
        //TODO:test
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Query query = entityManager.createQuery("select s from Student s join fetch s.studentCourseList sc where s.id=?1");
        query.setParameter(1, id);
        Student student = (Student) query.getSingleResult();
        Iterator<Student_Course> itr = student.getStudentCourseList().iterator();
        while (itr.hasNext()) {
            Student_Course sc = itr.next();
            if (sc.getStudent().getId() == id) {
                itr.remove();
                entityManager.remove(sc);
            }
        }
        tx.commit();
        return 0;
    }

    @Override
    public int deleteAllStudent() {
        //TODO
        return 0;
    }
}
