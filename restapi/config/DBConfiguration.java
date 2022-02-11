package com.yintaowang.assignment.restapi.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Slf4j
public class DBConfiguration {

    private static final DBConfiguration dbConfiguration = new DBConfiguration();
    private static final EntityManager entityManager = dbConfiguration.getEntityManagerFactory(dbConfiguration.getDataSource(), dbConfiguration.getProperties()).createEntityManager();

    public static EntityManager getEntityManager(){
        return entityManager;
    }

//    @RequestMapping("/lombok")
    private DataSource getDataSource() {
        log.trace("Database Configuration: get data source.....");
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/");
        return dataSource;
    }

    private Properties getProperties() {
        log.trace("Database Configuration: get properties.....");
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        return properties;
    }

    private EntityManagerFactory getEntityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
        log.trace("Database Configuration: creating EntityManager..........");
        final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setPackagesToScan("com/yintaowang/assignment/restapi");
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setJpaProperties(hibernateProperties);
        emfb.setPersistenceUnitName("demo-unit");
        emfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emfb.afterPropertiesSet();
        log.trace("Database Configuration: EntityManger created.........");
        return emfb.getObject();
    }
}
