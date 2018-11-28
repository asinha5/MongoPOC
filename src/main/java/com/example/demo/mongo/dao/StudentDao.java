package com.example.demo.mongo.dao;

import java.util.List;

import com.example.demo.mongo.model.Student;

public interface StudentDao {
	
	List<Student> getAllStudents();
	Student getStudentById(int studentid);
	Student addNewUser(Student student);
	void deleteUserByID(int studentId);

}
