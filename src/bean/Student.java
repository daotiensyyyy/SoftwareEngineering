package bean;

import java.util.Date;

public class Student extends User {
	private String student_faculty;
	private String student_class;
	
	public Student(String code, String firstname, String lastname, String address, String email, Date birthday,
			String phone, String username, String password, String role, String status, String student_faculty,
			String student_class) {
		super(code, firstname, lastname, address, email, birthday, phone, username, password, role, status);
		this.student_faculty = student_faculty;
		this.student_class = student_class;
	}
	
	public Student() {
		
	}

	public String getStudent_faculty() {
		return student_faculty;
	}

	public void setStudent_faculty(String student_faculty) {
		this.student_faculty = student_faculty;
	}

	public String getStudent_class() {
		return student_class;
	}

	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address
				+ ", email=" + email + ", birthday=" + birthday + ", phone=" + phone + ", student_falcuty=" + student_faculty + ", student_class=" +
				student_class + ", username=" + username	+ ", password=" + password + ", role=" + role + ", status=" + status + "]";

	}
	
	
}
