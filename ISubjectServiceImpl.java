package com.g3.spc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.spc.entities.Subject;
import com.g3.spc.repository.ISubjectRepository;

@Service
public class ISubjectServiceImpl implements ISubjectService{
	
	@Autowired
	private ISubjectRepository subjectRepo;


	@Override
	@Transactional
	public Subject addSubject(Subject subject) {
		subjectRepo.save(subject);
		return subject;
	}

	@Override
	public List<Subject> retrieveAllSubjects() {
		return subjectRepo.findAll();
	}

	@Override
	@Transactional
	public String deleteSubject(int id) {
		Subject s = subjectRepo.findById(id).get();
		String title = s.getTitle();
		subjectRepo.delete(s);
		return "Subject with id " + id + ", and title " + title +" is deleted.";
	}
	
	

}
