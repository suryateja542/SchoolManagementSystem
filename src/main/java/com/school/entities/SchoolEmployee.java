package com.school.entities;

public class SchoolEmployee {
		
		int employeeId;
		String employeeName;
		String password;
		
		
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public SchoolEmployee(int employeeId, String employeeName, String password) {
			super();
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.password = password;
		}
		
		public SchoolEmployee() {
			super();
			// TODO Auto-generated constructor stub
		}	

}	
