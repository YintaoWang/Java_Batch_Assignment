package com.yintaowang.assignment.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyRestAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyRestAPIApplication.class, args);
    }
}
/**
 * homework:
 * create rest api for previous orm project
 * 1. write Readme
 * 2. many - many
 * endpoint to create student
 * endpoint to create teacher
 * endpoint to register student with teacher
 * endpoint to update student
 * endpoint to get students(consider pagination)
 * 3. exception handling
 * 4. log
 * deadline before Friday Morning
 */