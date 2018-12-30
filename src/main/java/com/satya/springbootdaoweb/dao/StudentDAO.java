package com.satya.springbootdaoweb.dao;

import java.sql.SQLException;
import java.util.List;

import com.satya.springbootdaoweb.domain.Student;

public interface StudentDAO {
	
	int saveStudent(Student s) throws SQLException;
	
	boolean updateStudent(Student s) throws SQLException;
	
	boolean deleteStudent(int id) throws SQLException;
	
	List<Student> findAllStudents() throws SQLException;
	
	Student findByStudentId(int id) throws SQLException;

}
