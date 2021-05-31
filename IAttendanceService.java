package com.g3.spc.service;

import java.time.LocalDate;
import java.util.List;

import com.g3.spc.entities.Attendance;
import com.g3.spc.entities.Student;

public interface IAttendanceService {
	public Attendance addAttendance(Attendance attendance);
	public Attendance updateAttendance(Attendance attendance);
	public List<Attendance> listAttendanceByMonth(int month);
	public List<Attendance> listAttendanceByStudent(Student student);
	
	
}
