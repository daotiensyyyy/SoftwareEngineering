package bean;

import java.util.Date;

public class Course {
	private String course_id;
	private String course_name;
	private String course_credits;
	private String day;
	private String room;
	private String semester;
	private Date start_time;
	private Date end_time;
	
	public Course() {
		
	}

	public Course(String course_id, String course_name, String course_credits, String day, String room, String semester,
			Date start_time, Date end_time) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_credits = course_credits;
		this.day = day;
		this.room = room;
		this.semester = semester;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_credits() {
		return course_credits;
	}

	public void setCourse_credits(String course_credits) {
		this.course_credits = course_credits;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_credits=" + course_credits + ", day=" + day
				+ ", room=" + room + ", semester=" + semester + ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
	
}
