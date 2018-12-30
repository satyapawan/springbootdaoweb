package com.satya.springbootdaoweb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.CollectionReferringAccumulator;
import com.satya.springbootdaoweb.dao.StudentDAO;
import com.satya.springbootdaoweb.domain.Student;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDao;
	
	@Override
	public int saveStudent(Student s) {
		int pk = 0;
		try {
			 pk = studentDao.saveStudent(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk;
	}

	@Override
	public boolean updateStudent(Student s) {
		try {
			return studentDao.updateStudent(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		try {
			return studentDao.deleteStudent(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		try {
			students = studentDao.findAllStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.unmodifiableList(students);
	}

	@Override
	public Student getStudentById(int id) {
		Student student = new Student();
		try {
			student = studentDao.findByStudentId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

}
