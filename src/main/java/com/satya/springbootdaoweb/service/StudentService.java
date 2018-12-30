package com.satya.springbootdaoweb.service;

import java.util.List;

import com.satya.springbootdaoweb.domain.Student;

public interface StudentService {
	
	int saveStudent(Student s);

	boolean updateStudent(Student s);

	boolean deleteStudent(int id);

	List<Student> getAllStudents();

	Student getStudentById(int id);

}
