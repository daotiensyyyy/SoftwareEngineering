package bean;

import java.sql.Date;

public class RegistrationForm {
	private String course_id;
	private String student_code;
	private String semester;
	private Date registration_date;
	public RegistrationForm(String course_id, String student_code, String semester, Date registration_date) {
		super();
		this.course_id = course_id;
		this.student_code = student_code;
		this.semester = semester;
		this.registration_date = registration_date;
	}
	public RegistrationForm() {
		
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getStudent_code() {
		return student_code;
	}
	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	@Override
	public String toString() {
		return "RegistrationForm [course_id=" + course_id + ", student_code=" + student_code + ", semester=" + semester
				+ ", registration_date=" + registration_date + "]";
	}
	
}
