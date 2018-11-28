package com.example.demo.mongo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Student")
@AllArgsConstructor
public class Student {
	
	private int id;
	private String name;
	private List<Scores> scores;

}
