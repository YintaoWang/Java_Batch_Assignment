package com.yintaowang.assignment.MyJPAHomework;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 * Homework:
 * <p>
 * 1. build relation between hibernate (entitymanager) and database table
 * 2. create many to many relation in database
 * 3. use 1 - m + m - 1 in hibernate
 * 4. write jpql to select data / select data by id / join data
 * 5. write jpql to remove data
 * <p>
 * don't use : spring data jpa
 * many to many annotation
 * hibernate auto creation
 */
public class MyJPA {

    private DataSource getDataSource() {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("root");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/");
        return dataSource;
    }

    private Properties getProperties() {
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        return properties;
    }

    private EntityManagerFactory getEntityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
        final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setPackagesToScan("com/yintaowang/assignment/MyJPAHomework");
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setJpaProperties(hibernateProperties);
        emfb.setPersistenceUnitName("demo-unit");
        emfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emfb.afterPropertiesSet();
        return emfb.getObject();
    }

    public static void main(String[] args) {

        MyJPA myJPA = new MyJPA();
        DataSource dataSource = myJPA.getDataSource();
        Properties properties = myJPA.getProperties();
        EntityManagerFactory entityManagerFactory = myJPA.getEntityManagerFactory(dataSource, properties);
        EntityManager em = entityManagerFactory.createEntityManager();
//        PersistenceUnitUtil unitUtil = entityManagerFactory.getPersistenceUnitUtil();

        //select
        List<Student> studentList = (List<Student>) em.createQuery("select s from Student s").getResultList();
        Student stu = em.find(Student.class, 1);
        Student s = (Student) em.createQuery("select s from Student s where s.id = 2").getSingleResult();
        List<Student> studentList1 = (List<Student>) em.createQuery("select distinct s from Student s join s.student_courseList").getResultList();
        List<Course> courseList = (List<Course>) em.createQuery("select c from Course c join c.student_courseList").getResultList();
        System.out.println(studentList);
        System.out.println(stu);
        System.out.println(s);
        System.out.println(studentList1);
        System.out.println(courseList);

        //remove data from student table
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        int result = em.createNativeQuery("delete from Student s where s.id = 3").executeUpdate();
        tx.commit();
        System.out.println(result);
    }
}
