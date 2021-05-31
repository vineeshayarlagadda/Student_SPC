package com.g3.spc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.spc.dto.StudentDto;
import com.g3.spc.entities.Attendance;
import com.g3.spc.entities.Student;
import com.g3.spc.entities.Subject;
import com.g3.spc.exception.StudentIDNotFoundException;
import com.g3.spc.repository.IStudentRepository;
import com.g3.spc.repository.ISubjectRepository;

@Service
public class IStudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentRepository studentRepo;
	
	@Autowired
	private ISubjectRepository subjectRepo;
	
	@Override
	@Transactional
	public Student addStudent(Student student) {
		List<Integer> subjectIdList = student.getSubjectIdList();
		List<Subject> subjectsList  = subjectRepo.findAll();
		List<Subject> studentSubjectsList = new ArrayList<>();
		for(int id : subjectIdList) {
			Subject subject = subjectRepo.findById(id).get();
			studentSubjectsList.add(subject);
		}
		student.setSubjects(studentSubjectsList);
		studentRepo.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		long id=student.getStudentId();
		Student s = studentRepo.findById((long) id).get();
		s.setAddress(student.getAddress());
		s.setAttendance(student.getAttendance());
		s.setClassDiary(student.getClassDiary());
		s.setCurrentClass(student.getCurrentClass());
		s.setDateOfBirth(student.getDateOfBirth());
		s.setEmailId(student.getEmailId());
		s.setFee(student.getFee());
		s.setMobileNumber(student.getMobileNumber());
		s.setName(student.getName());
		s.setSubjects(student.getSubjects());
		return studentRepo.save(s);
	}

	@Override
	@Transactional
	public String deleteStudent(long id) {
		studentRepo.deleteById(id);
		return "Deleted the student with id " + id ;
	}

	@Override
	public List<Student> retrieveAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student retrieveStudentById(int id) throws StudentIDNotFoundException{
		Optional<Student> s1 = studentRepo.findById((long) id);
		if(s1.isEmpty()) throw new StudentIDNotFoundException(id);
		return studentRepo.findById((long) id).get();
	}
	
	@Override
	public StudentDto displayStudent(Student s) {
		StudentDto studentDto = new StudentDto(s.getStudentId(),s.getName(),s.getCurrentClass().getClassId(),s.getEmailId(),s.getMobileNumber(),s.getDateOfBirth(),s.getAddress(),s.getClassDiary().getClassDiaryId(),s.getSubjects());
		return studentDto;
	}
	
}
