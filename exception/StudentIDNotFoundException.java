package com.g3.spc.exception;



public class StudentIDNotFoundException extends Exception {
	private long studentId;

	public StudentIDNotFoundException(long studentId) {
		super();
		this.studentId = studentId;
	}

	public StudentIDNotFoundException() {
		super();
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	public StudentIDNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public StudentIDNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentIDNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
