package com.g3.spc.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.g3.spc.entities.Attendance;
import com.g3.spc.entities.Student;
import com.g3.spc.repository.IAttendanceRepository;

@Service
public class IAttendanceServiceImpl implements IAttendanceService{
	
	@Autowired
	private IAttendanceRepository attendanceRepo;

	@Override
	@Transactional
	public Attendance addAttendance(Attendance attendance) {
		attendanceRepo.save(attendance);
		return attendance;
	}

	@Override
	public Attendance updateAttendance(Attendance attendance) {
		long id=attendance.getAttendanceId();
		Attendance a = attendanceRepo.findById((int) id).get();
		a.setDateOfClass(attendance.getDateOfClass());
		a.setPresent(attendance.isPresent());
		return attendanceRepo.save(a);
	}

	@Override
	public List<Attendance> listAttendanceByMonth(int month) {
		List<Attendance> monthlyAttendanceList = new ArrayList<>();
		List<Attendance> fullAttendanceList = attendanceRepo.findAll();
		for(Attendance a : fullAttendanceList) {
			if(a.getDateOfClass().getMonth()==Month.of(month)) monthlyAttendanceList.add(a);
		}
		return monthlyAttendanceList;
	}

	@Override
	public List<Attendance> listAttendanceByStudent(Student student) {
//		List<Attendance> studentAttendanceList = new ArrayList<>();
//		List<Attendance> fullAttendanceList = attendanceRepo.findAll();
//		for(Attendance a : fullAttendanceList) {
//			
//		}
		return null;
	}
	
	

}
