package com.example.demo.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.mongo.dao.StudentDao;
import com.example.demo.mongo.daoImpl.StudentDaoImpl;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.example.demo.mongo.dao")
@ComponentScan("com.example.demo.mongo.controller")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public StudentDao getStudent() {
		return new StudentDaoImpl();
	}
}
