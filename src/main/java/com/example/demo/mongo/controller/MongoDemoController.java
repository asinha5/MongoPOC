package com.example.demo.mongo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mongo.dao.StudentDao;
import com.example.demo.mongo.dao.StudentRepository;
import com.example.demo.mongo.model.Student;

@RestController
@RequestMapping("/mongoapi")
public class MongoDemoController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(value="/listAllStudents",method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studentList = studentDao.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/listStudentbyid/{studentId}", method=RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudentById(@PathVariable int studentId){
		List<Student> studentList = new ArrayList<Student>();
		Student student = studentDao.getStudentById(studentId);
		studentList.add(student);
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<List<Student>> createStudent(@RequestBody Student student) {
		studentDao.addNewUser(student);
		List<Student> studentList = studentDao.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);

	}
	
	@RequestMapping(value="/deleteById/{studentId}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudentById(@PathVariable int studentId) {
		studentDao.deleteUserByID(studentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
