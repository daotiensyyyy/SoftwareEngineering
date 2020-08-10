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

import connection.DBConnect;
import model.Course;
import model.RegistrationForm;
import model.Student;
import model.Teacher;

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
		String sql = "select * from course ";
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
				c.setTime(resultSet.getString(7));
				c.setSemester(resultSet.getString(8));
				c.setStart_time(resultSet.getString(9));
				c.setEnd_time(resultSet.getString(10));

				listCourse.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCourse;

	}

	// lay ds dang ky hoc
	/*
	 * public List<RegistrationForm> getAllRegistration() { RegistrationForm rf =
	 * null; String sql = "select * from student_management.registration_form";
	 * connection = DBConnect.getJDBCConnection(); try { listRF = new
	 * ArrayList<RegistrationForm>(); preparedStatement =
	 * connection.prepareStatement(sql); resultSet =
	 * preparedStatement.executeQuery(sql); while (resultSet.next()) { rf = new
	 * RegistrationForm(); rf.setCourse_id(resultSet.getString(1));
	 * rf.setStudent_code(resultSet.getString(2));
	 * rf.setSemester(resultSet.getString(3));
	 * rf.setRegistration_date(resultSet.getDate(4));
	 * 
	 * listRF.add(rf); } } catch (Exception e) { e.printStackTrace(); } return
	 * listRF;
	 * 
	 * }
	 */

	// dang ky hoc
	public RegistrationForm register(RegistrationForm rf) throws SQLException {
		connection = DBConnect.getJDBCConnection();
		preparedStatement = null;
		String sql = "insert into registration values(?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, rf.getStudent_code());
			preparedStatement.setString(2, rf.getCourse_id());
			preparedStatement.setString(3, rf.getCourse_name());
			preparedStatement.setString(4, rf.getDay());
			preparedStatement.setString(5, rf.getRoom());
			preparedStatement.setString(6, rf.getTime());
			preparedStatement.setString(7, rf.getSemester());
			preparedStatement.setString(8, rf.getStart_time());
			preparedStatement.setString(9, rf.getEnd_time());
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
			String sql = "select distinct * from registration where student_code='" + student_code + "'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				rf = new RegistrationForm();

				rf.setStudent_code(resultSet.getString(1));
				rf.setCourse_id(resultSet.getString(2));
				rf.setCourse_name(resultSet.getString(3));
				rf.setDay(resultSet.getString(4));
				rf.setRoom(resultSet.getString(5));
				rf.setTime(resultSet.getString(6));
				rf.setSemester(resultSet.getString(7));
				rf.setStart_time(resultSet.getString(8));
				rf.setEnd_time(resultSet.getString(9));
				
				list.add(rf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return (ArrayList<RegistrationForm>) list;
	}

	public boolean checkExist(String student_code, String course_id) {
		try {
			ResultSet  rs=new DBConnect().selectFromDatabase("select * from registration where student_code='"+student_code+"' "
					+ "and course_id='"+course_id+"'");
			while(rs.next()){
				if(rs.getString(1).equals(student_code) && rs.getString(2).equals(course_id)){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean checkDay(String student_code, String day, String time) {
		try {
			ResultSet  rs=new DBConnect().selectFromDatabase("select * from registration where student_code='"+student_code+"'"
					+ "and day='"+day+"'and time='"+time+"'");
			while(rs.next()){
				if(rs.getString(1).equals(student_code)&& rs.getString(4).equals(day)&& rs.getString(6).equals(time)){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	//them vao ds da chon
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

	public boolean checkExist(String course_id){
		for (int i = 0; i < tmp.size(); i++) {
			if(tmp.get(i).getCourse_id().equals(course_id)){
				return true;
			}
		}
		return false;
	}
	
	//xoa khoi ds da chon
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
	
	public ArrayList<Course> filterList(String course_id) {
		List<Course> list = null;
		Course c = null;
		connection = DBConnect.getJDBCConnection();
		try {
			list = new ArrayList<Course>();
			String sql = "select * from course where course_id='" + course_id + "'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				c = new Course();
				
				c.setCourse_id(resultSet.getString(2));
				c.setCourse_name(resultSet.getString(3));
				c.setCourse_credits(resultSet.getString(4));
				c.setDay(resultSet.getString(5));
				c.setRoom(resultSet.getString(6));
				c.setTime(resultSet.getString(7));
				c.setSemester(resultSet.getString(8));
				c.setStart_time(resultSet.getString(9));
				c.setEnd_time(resultSet.getString(10));
				
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return (ArrayList<Course>) list;
	}


	
	public static void main(String[] args) throws SQLException {
		ManageStudent ms = new ManageStudent();
//		RegistrationForm rf = new RegistrationForm("2", "2","214282", "1", "1", "2", "2", "22","22");
//		System.out.println(ms.getListStudent());
		System.out.println(ms.getListCourse());
//		System.out.println(ms.getAllRegistration());
//		System.out.println(ms.checkLogin("17130197", "123456"));
//		ms.register(rf);
//		System.out.println(ms.getByStudent_code("17130094"));
//		ms.insert("214252");
//		System.out.println(ms.tmp);
//		System.out.println(ms.checkExist("214252"));
//		System.out.println(ms.mapStudent.get("17130198"));
//		System.out.println(ms.filterList("214370"));
		System.out.println(ms.checkExist("17130084", "214451"));
	}
}
