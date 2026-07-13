package com.ansht.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CollegeManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollegeManagementApplication.class, args);
    }
}
