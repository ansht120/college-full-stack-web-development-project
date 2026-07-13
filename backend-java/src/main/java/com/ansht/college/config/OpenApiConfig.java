package com.ansht.college.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI collegeManagementOpenApi() {
        return new OpenAPI().info(new Info()
                .title("College Management API")
                .version("v1")
                .description("Student result management APIs with JWT security and role-based access."));
    }
}
