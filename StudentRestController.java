package com.g3.spc.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.dto.StudentDto;
import com.g3.spc.entities.Student;
import com.g3.spc.exception.StudentIDNotFoundException;
import com.g3.spc.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "School Parent communication App")
public class StudentRestController {
	
	@Autowired
	private IStudentService students;
	
	
	public StudentRestController() {
		System.out.println("------>> Student Rest Controller Constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : School Parent Communication App" + LocalDateTime.now();
	}
	
	
	
	@ApiOperation(value = "Student post mapping" , response = Student.class)
	@PostMapping("/students/insertStudent")
	public StudentDto insertStudent(@RequestBody @Valid Student s) {
		Student s1=students.addStudent(s);
		StudentDto studentDto = students.displayStudent(s1);
		return studentDto;
	}
	
	@PutMapping("/students/update")
	public StudentDto updateStudent(@RequestBody Student s) throws StudentIDNotFoundException
	{
		Student s1 = students.updateStudent(s);
		StudentDto studentDto = students.displayStudent(s1);
		return studentDto;
	}
	
	@PostMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable long id) throws StudentIDNotFoundException{
		return students.deleteStudent(id);
	}
	
	
	@ApiOperation(value = "Student Get mapping to fetch all students" , response = List.class)
	@GetMapping("/students/showAllStudents")
	public List<StudentDto> getAllStudents(){
		List<Student> studentsList = students.retrieveAllStudents();
		List<StudentDto> list = new ArrayList<>();
		for(Student s : studentsList) {
			StudentDto studentDto = students.displayStudent(s);
			list.add(studentDto);
		}
		return list;
	}
	
	
	@GetMapping("/students/search/{id}")
	public StudentDto getStudentById(@PathVariable int id) throws StudentIDNotFoundException{
		
		Student s = students.retrieveStudentById(id);
		StudentDto studentDto = students.displayStudent(s);
		return studentDto;
	}
	
	
	

//	@Autowired
//	private IFeeService fee;
	
//	@PostMapping("/fees")
//	public Fee insertFee(@RequestBody Fee f) {
//		fee.addFee(f);
//		return f;
//	}
	

}
