package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import bean.Course;
import bean.RegistrationForm;
import bean.Student;
import bean.Teacher;
import connection.DBConnect;

public class ManageStudent {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	private static ArrayList<Course> listCourse = new ArrayList<>();
	private static ArrayList<RegistrationForm> listRF = new ArrayList<>();
	public static ArrayList<Course> tmp= new ArrayList<>();

	public ManageStudent() {

	}
	
	// lay ds mon hoc
	public List<Course> getListCourse() {
		Course c = null;
		String sql = "select * from student_management.course ";
		connection = DBConnect.getJDBCConnection();
		try {
			listCourse = new ArrayList<Course>();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				c = new Course();
				c.setCourse_id(resultSet.getString(2));
				c.setCourse_name(resultSet.getString(3));
				c.setCourse_credits(resultSet.getString(4));
				c.setDay(resultSet.getString(5));
				c.setRoom(resultSet.getString(6));
				c.setSemester(resultSet.getString(7));
				c.setStart_time(resultSet.getString(8));
				c.setEnd_time(resultSet.getString(9));

				listCourse.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCourse;

	}

	// lay ds dang ky hoc
//	public List<RegistrationForm> getAllRegistration() {
//		RegistrationForm rf = null;
//		String sql = "select * from student_management.registration_form";
//		connection = DBConnect.getJDBCConnection();
//		try {
//			listRF = new ArrayList<RegistrationForm>();
//			preparedStatement = connection.prepareStatement(sql);
//			resultSet = preparedStatement.executeQuery(sql);
//			while (resultSet.next()) {
//				rf = new RegistrationForm();
//				rf.setCourse_id(resultSet.getString(1));
//				rf.setStudent_code(resultSet.getString(2));
//				rf.setSemester(resultSet.getString(3));
//				rf.setRegistration_date(resultSet.getDate(4));
//
//				listRF.add(rf);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return listRF;
//
//	}

	// dang ky hoc
	public RegistrationForm register(RegistrationForm rf) throws SQLException {
		connection = DBConnect.getJDBCConnection();
		preparedStatement = null;
		String sql = "insert into registration values(?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, rf.getStudent_code());
			preparedStatement.setString(2, rf.getCourse_id());
			preparedStatement.setString(3, rf.getCourse_name());
			preparedStatement.setString(4, rf.getDay());
			preparedStatement.setString(5, rf.getRoom());
			preparedStatement.setString(6, rf.getSemester());
			preparedStatement.setString(7, rf.getStart_time());
			preparedStatement.setString(8, rf.getEnd_time());
			int row = preparedStatement.executeUpdate();
			if (row < 1) {
				rf = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rf = null;
		} finally {
			connection.close();
		}
		System.out.println("done");
		return rf;
	}

	// lay ds mon hoc sv da dang ky theo mssv
	public List<RegistrationForm> getByStudent_code(String student_code) {
		connection = DBConnect.getJDBCConnection();
		preparedStatement = null;
		List<RegistrationForm> list = null;
		RegistrationForm rf = null;
		try {
			list = new ArrayList<RegistrationForm>();
			String sql = "select distinct * from student_management.registration where student_code='" + student_code + "'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				rf = new RegistrationForm();

				rf.setStudent_code(resultSet.getString(1));
				rf.setCourse_id(resultSet.getString(2));
				rf.setCourse_name(resultSet.getString(3));
				rf.setDay(resultSet.getString(4));
				rf.setRoom(resultSet.getString(5));
				rf.setSemester(resultSet.getString(6));
				rf.setStart_time(resultSet.getString(7));
				rf.setEnd_time(resultSet.getString(8));
				
				list.add(rf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return (ArrayList<RegistrationForm>) list;
	}
	
	public boolean checkExist(String course_id){
		for (int i = 0; i < tmp.size(); i++) {
			if(tmp.get(i).getCourse_id().equals(course_id)){
				return true;
			}
		}
		return false;
	}
	
	public boolean insert(String course_id){
		getListCourse();
		boolean check = checkExist(course_id);
		for (int i = 0; i <listCourse.size(); i++) {
				if(listCourse.get(i).getCourse_id().equals(course_id) && check==false){
					tmp.add(listCourse.get(i));
					return true;
				}
		}
		return false;
	}
	public boolean delete(String course_id){
		for (int i = 0; i < tmp.size(); i++) {
			if(tmp.get(i).getCourse_id().equals(course_id)){
				tmp.remove(i);
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Course> getList() {
		return listCourse;
	}

	public static void setList(ArrayList<Course> listCourse) {
		ManageStudent.listCourse = listCourse;
	}

	public static ArrayList<Course> getTmp() {
		return tmp;
	}

	public static void setTmp(ArrayList<Course> tmp) {
		ManageStudent.tmp = tmp;
	}
	
	public boolean checkDB(String student_code, String course_id) {
		String sql = "" ;
		try {
			new DBConnect().doSQLScript(sql);
		}catch(Exception e) {
			System.out.println("error");
			return false;
		}
		return true;
	}

	
	public static void main(String[] args) throws SQLException {
		ManageStudent ms = new ManageStudent();
//		RegistrationForm rf = new RegistrationForm("2", "214282", "1", "1", "2", "2", "22","22");
//		System.out.println(ms.getListStudent());
//		System.out.println(ms.getListCourse());
//		System.out.println(ms.getAllRegistration());
//		System.out.println(ms.checkLogin("17130197", "123"));
//		ms.register(rf);
		System.out.println(ms.getByStudent_code("17130094"));
//		ms.insert("214252");
//		System.out.println(ms.tmp);
//		System.out.println(ms.checkExist("214252"));
//		System.out.println(ms.mapStudent.get("17130198"));
	}
}
