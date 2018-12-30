package com.satya.springbootdaoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.satya.springbootdaoweb.domain.Student;
import com.satya.springbootdaoweb.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/savestudent")
	@ResponseBody
	public int saveStudent(@RequestBody Student s) {
		return studentService.saveStudent(s);
	}
	
	@PutMapping("/updatestudent")
	@ResponseBody
	public boolean updateStudent(@RequestBody Student s) {
		return studentService.updateStudent(s);
	}
	
	@DeleteMapping("/deletestudent")
	@ResponseBody
	public boolean deleteStudent(@RequestParam int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/getallstudents")
	@ResponseBody
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getstudentbyid/{id}")
	@ResponseBody
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}


}
