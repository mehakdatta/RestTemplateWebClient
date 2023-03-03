package com.project6;

public class Student {
	private int studentId;
	private String studentName;
	private String address;
	private int collegeId;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public Student(int studentId, String studentName, String address, int collegeId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
		this.collegeId = collegeId;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
