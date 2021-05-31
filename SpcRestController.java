package com.g3.spc.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.dto.StudentDto;
import com.g3.spc.entities.Attendance;
import com.g3.spc.entities.ClassDiary;
import com.g3.spc.entities.DiaryNotes;
import com.g3.spc.entities.Fee;
//import com.g3.spc.entities.Parent;
import com.g3.spc.entities.Student;
import com.g3.spc.entities.Subject;
import com.g3.spc.exception.StudentIDNotFoundException;
import com.g3.spc.service.IAttendanceService;
import com.g3.spc.service.IClassDiaryService;
import com.g3.spc.service.IDiaryNotesService;
import com.g3.spc.service.IFeeService;
import com.g3.spc.service.IParentService;
import com.g3.spc.service.IStudentService;
import com.g3.spc.service.ISubjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "School Parent communication App")
public class SpcRestController {
	
	@Autowired
	private IStudentService students;
	
	@Autowired
	private ISubjectService subject;
	
	@Autowired
	private IAttendanceService attendance;
	
	@Autowired
	private IFeeService fee;
	
	
	public SpcRestController() {
		System.out.println("------>> SPC Rest Controller Constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : School Parent Communication App" + LocalDateTime.now();
	}
	
	
	@PostMapping("/subjects/abc")
	public Subject insertSubject(@RequestBody Subject s) {
		System.out.println("HIIIIIIIIIIIIIIIIIIIIIII");
		subject.addSubject(s);
		return s;
	}
	
	@GetMapping("/showSubjects")
	public List<Subject> showAllSubjects(){
		return subject.retrieveAllSubjects();
	}
	
	@ApiOperation(value = "Student post mapping" , response = Student.class)
	@PostMapping("/students/insertStudent")
	public StudentDto insertStudent(@RequestBody @Valid Student s) {
		Student s1=students.addStudent(s);
		StudentDto studentDto = students.displayStudent(s1);
		return studentDto;
	}
	
	
	@ApiOperation(value = "Student Get mapping to fetch all students" , response = List.class)
	@GetMapping("/students/showAllStudents")
	public List<Student> getAllStudents(){
		return students.retrieveAllStudents();
	}
	
	@PostMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		return students.deleteStudent(id);
	}
	
	@PutMapping("/students/update")
	public StudentDto updateStudent(@RequestBody Student s)
	{
		Student s1 = students.updateStudent(s);
		StudentDto studentDto = students.displayStudent(s1);
		return studentDto;
	}
	
	@GetMapping("/students/search/{id}")
	public StudentDto getStudentById(@PathVariable int id) throws StudentIDNotFoundException{
		
		Student s = students.retrieveStudentById(id);
		StudentDto studentDto = students.displayStudent(s);
		return studentDto;
	}
	
	
	@PostMapping("/attendance/insertAttendance")
	public Attendance insertAttendance(@RequestBody Attendance a) {
		attendance.addAttendance(a);
		return a;
	}
	
	@GetMapping("/attendance/showAllAttendance/{month}")
	public List<Attendance> getAllAttendance(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate month){
		return attendance.listAttendanceByMonth(month);
	}
	
	@PutMapping("/attendance/update")
	public Attendance updateProduct(@RequestBody Attendance a)
	{
		return attendance.updateAttendance(a);
	}
	
//	@PostMapping("/fees")
//	public Fee insertFee(@RequestBody Fee f) {
//		fee.addFee(f);
//		return f;
//	}

}
