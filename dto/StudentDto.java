package com.g3.spc.dto;

import java.time.LocalDate;
import java.util.List;

import com.g3.spc.entities.Address;
import com.g3.spc.entities.Subject;

public class StudentDto {
	
	private long studentId;
	private String name;
	private String studentClass;
	private String email;
	private String mobileNum;
	private LocalDate dob;
	private Address address;
	private int classDiaryId;
	private List<Subject> subjects;
	
	public StudentDto(long studentId, String name, String studentClass, String email, String mobileNum, LocalDate dob,
			Address address, int classDiaryId, List<Subject> subjects) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.studentClass = studentClass;
		this.email = email;
		this.mobileNum = mobileNum;
		this.dob = dob;
		this.address = address;
		this.classDiaryId = classDiaryId;
		this.subjects = subjects;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getClassDiaryId() {
		return classDiaryId;
	}

	public void setClassDiaryId(int classDiaryId) {
		this.classDiaryId = classDiaryId;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", name=" + name + ", studentClass=" + studentClass + ", email="
				+ email + ", mobileNum=" + mobileNum + ", dob=" + dob + ", address=" + address + ", classDiaryId="
				+ classDiaryId + ", subjects=" + subjects + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + classDiaryId;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobileNum == null) ? 0 : mobileNum.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((studentClass == null) ? 0 : studentClass.hashCode());
		result = prime * result + (int) (studentId ^ (studentId >>> 32));
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (classDiaryId != other.classDiaryId)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobileNum == null) {
			if (other.mobileNum != null)
				return false;
		} else if (!mobileNum.equals(other.mobileNum))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (studentClass == null) {
			if (other.studentClass != null)
				return false;
		} else if (!studentClass.equals(other.studentClass))
			return false;
		if (studentId != other.studentId)
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}

	

}
