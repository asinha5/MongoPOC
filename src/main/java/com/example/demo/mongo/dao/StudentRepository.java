package com.example.demo.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.mongo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

}
