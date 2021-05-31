package com.g3.spc.service;

import java.util.List;

import com.g3.spc.entities.Subject;

public interface ISubjectService{
	public Subject addSubject(Subject subject);
	public List<Subject> retrieveAllSubjects();
	public String deleteSubject(int subjectId);

}
