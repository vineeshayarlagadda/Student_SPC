package com.g3.spc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.entities.Subject;
import com.g3.spc.service.ISubjectService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value = "School Parent communication App")
public class SubjectRestController {
	
	@Autowired
	private ISubjectService subject;
	
	
	public SubjectRestController() {
		System.out.println("------>> Subject Rest Controller Constructor");
	}
	
	@PostMapping("/subjects")
	public Subject insertSubject(@RequestBody Subject s) {
		subject.addSubject(s);
		return s;
	}
		
	@GetMapping("/subjects")
	public List<Subject> showAllSubjects(){
		return subject.retrieveAllSubjects();
	}
	
	@PostMapping("/subjects/{id}")
	public String deleteSubject(@PathVariable int id) {
		return subject.deleteSubject(id);
	}

}
