package model;

import java.util.Date;

public class Course {
	private String course_id;
	private String course_name;
	private String course_credits;
	private String day;
	private String room;
	private String time;
	private String semester;
	private String start_time;
	private String end_time;
	
	public Course() {
		
	}

	public Course(String course_id, String course_name, String course_credits, String day, String room, String time,
			String semester, String start_time, String end_time) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_credits = course_credits;
		this.day = day;
		this.room = room;
		this.time = time;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_credits=" + course_credits
				+ ", day=" + day + ", room=" + room + ", time=" + time + ", semester=" + semester + ", start_time="
				+ start_time + ", end_time=" + end_time + "]";
	}


	
}
