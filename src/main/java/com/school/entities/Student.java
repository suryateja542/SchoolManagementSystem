package com.school.entities;

public class Student {

	long studId;
	String studName;
	String studAddress;
	int studclass;
	String studPassword;
	long phone;
	String studEmail;
	public long getStudId() {
		return studId;
	}
	public void setStudId(long studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStuddAdress() {
		return studAddress;
	}
	public void setStudAdress(String studAddress) {
		this.studAddress = studAddress;
	}
	public int getStudclass() {
		return studclass;
	}
	public void setStudclass(int studclass) {
		this.studclass = studclass;
	}
	public String getStudPassword() {
		return studPassword;
	}
	public void setStudPassword(String studPassword) {
		this.studPassword = studPassword;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getStudEmail() {
		return studEmail;
	}
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	public Student(long studId, String studName, String studAddress, int studclass, String studPassword,
			long phone, String studEmail) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAddress = studAddress;
		this.studclass = studclass;
		this.studPassword = studPassword;
		this.phone = phone;
		this.studEmail = studEmail;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
