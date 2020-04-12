package com.dao;

import java.util.List;

import com.model.Student;


public interface StudentDao {

	List<Student> getAllStudents();
	
	void addStudent(Student student);
	
	
	
	
	
}
