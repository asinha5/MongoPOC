package com.example.demo.mongo.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.mongo.dao.StudentDao;
import com.example.demo.mongo.model.Student;

@Service
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private MongoOperations mongoOps;
	
	
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> newStudentList = mongoTemplate.findAll(Student.class);
		System.out.println(newStudentList);
		
		return newStudentList;
	}
	@Override
	public Student getStudentById(int studentid) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(studentid));
		return mongoTemplate.findOne(query, Student.class);
	}
	@Override
	public Student addNewUser(Student student) {
		mongoTemplate.save(student);
		return student;
	}
	
	@Override
	public void deleteUserByID(int studentId) {
		Query query = new Query(Criteria.where("id").is(studentId));
		mongoOps.remove(query, Student.class);
	}

}
