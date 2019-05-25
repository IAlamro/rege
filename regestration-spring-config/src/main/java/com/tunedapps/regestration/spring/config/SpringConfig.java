package com.tunedapps.regestration.spring.config;

import com.tunedapps.regestration.entities.Student;
import com.tunedapps.regestration.repository.IdGenerator;
import com.tunedapps.regestration.repository.Repository;
import com.tunedapps.regestration.repository.RepositoryImpl;
import com.tunedapps.regestration.repository.StudentsIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.tunedapps.regestration.rest")
@PropertySource("classpath:configuration.properties")
public class SpringConfig {

    @Value("${name}")
    private String name;

    @Bean
    public Repository<Long, Student> repository(IdGenerator<Long> idGenerator){
        return new RepositoryImpl<>(idGenerator);
    }

    @Bean
    public IdGenerator<Long> idGenerator(){
        return new StudentsIdGenerator();
    }
}
