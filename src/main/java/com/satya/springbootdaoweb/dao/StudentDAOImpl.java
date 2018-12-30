package com.satya.springbootdaoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satya.springbootdaoweb.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	DataSource dataSource;

	@Override
	public int saveStudent(Student s) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("insert into student(id, name, age) values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		prepareStatement.setInt(1, s.getId());
		prepareStatement.setString(2, s.getName());
		prepareStatement.setInt(3, s.getAge());
		int noOfRows = prepareStatement.executeUpdate();
		ResultSet rs = prepareStatement.getGeneratedKeys();
		if (rs.next()) {
		  return rs.getInt(1);
		}
		return noOfRows;
	}

	@Override
	public boolean updateStudent(Student s) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("update student set age=? where id=?");
		prepareStatement.setInt(1, s.getAge());
		prepareStatement.setInt(2, s.getId());
		int pk = prepareStatement.executeUpdate();
		return pk > 0;
	}

	@Override
	public boolean deleteStudent(int id) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("delete from student where id=?");
		prepareStatement.setInt(1, id);
		int pk = prepareStatement.executeUpdate();
		return pk > 0;
	}

	@Override
	public List<Student> findAllStudents() throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from student");
		ResultSet rs = prepareStatement.executeQuery();
		List<Student> students = new ArrayList<>();
 		while(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAge(s.getAge());
			students.add(s);
		}
		return students;
	}

	@Override
	public Student findByStudentId(int id) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from student where id=?");
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
 		while(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAge(rs.getInt(3));
			return s;
		}
		return null;
	}

}
