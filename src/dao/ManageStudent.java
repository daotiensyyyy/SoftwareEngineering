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

	public static Map<String, Student> mapStudent = getInfo();
	private static ArrayList<Student> listStudent = new ArrayList<>();
	private static ArrayList<Course> listCourse = new ArrayList<>();
	private static ArrayList<RegistrationForm> listRF = new ArrayList<>();
	public static ArrayList<Course> gioHang= new ArrayList<>();

	public ManageStudent() {

	}
	
	private static Map<String, Student> getInfo() {
		Map<String, Student> mapTemp = new HashMap<>();
		try {
			Student student = null;
			ResultSet resultSet = new DBConnect().selectFromDatabase("select * from student");
			while (resultSet.next()) {
				student = new Student();
				String code = resultSet.getString(2);
				String first_name = resultSet.getString(3);
				String last_name = resultSet.getString(4);
				String address = resultSet.getString(5);
				String email = resultSet.getString(6);
				Date birthday = resultSet.getDate(7);
				String phone = resultSet.getString(8);
				String faculty = resultSet.getString(9);
				String student_class = resultSet.getString(10);
				String username = resultSet.getString(11);
				String password = resultSet.getString(12);
				String role = resultSet.getString(13);
				String status = resultSet.getString(14);
				Student st = new Student(code, first_name, last_name, address, email, birthday, phone, username, password, role, status, faculty, student_class);
				mapTemp.put(st.getCode(), st);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mapTemp;

	}

	// lay ds sinh vien
	public List<Student> getListStudent() {
		Student student = null;
		String sql = "select * from student_management.student";
		connection = DBConnect.getJDBCConnection();
		try {
			listStudent = new ArrayList<Student>();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				student = new Student();
				student.setCode(resultSet.getString(2));
				student.setFirstname(resultSet.getString(3));
				student.setLastname(resultSet.getString(4));
				student.setAddress(resultSet.getString(5));
				student.setEmail(resultSet.getString(6));
				student.setBirthday(resultSet.getDate(7));
				student.setPhone(resultSet.getString(8));
				student.setStudent_faculty(resultSet.getString(9));
				student.setStudent_class(resultSet.getString(10));
				student.setUsername(resultSet.getString(11));
				student.setPassword(resultSet.getString(12));
				student.setRole(resultSet.getString(13));
				student.setStatus(resultSet.getString(14));

				listStudent.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStudent;

	}

	// kiem tra dang nhap
	public boolean checkLogin(String username, String password) {
		try {
			if (findStudentAccount(username, password) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// tim tai khoan cua sinh vien
	public Student findStudentAccount(String username, String password) {
		String sql = "SELECT * FROM student_management.student WHERE student_username = '" + username
				+ "' and student_password = '" + password + "'";
		Student student = null;
		try {
			ResultSet rs = new DBConnect().selectFromDatabase(sql);
			while (rs.next()) {
				student = new Student();
				student.setUsername(rs.getString("student_username"));
				student.setPassword(rs.getString("student_password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;

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
				c.setStart_time(resultSet.getDate(8));
				c.setEnd_time(resultSet.getDate(9));

				listCourse.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCourse;

	}

	// lay ds dang ky hoc
	public List<RegistrationForm> getAllRegistration() {
		RegistrationForm rf = null;
		String sql = "select * from student_management.registration_form";
		connection = DBConnect.getJDBCConnection();
		try {
			listRF = new ArrayList<RegistrationForm>();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				rf = new RegistrationForm();
				rf.setCourse_id(resultSet.getString(1));
				rf.setStudent_code(resultSet.getString(2));
				rf.setSemester(resultSet.getString(3));
				rf.setRegistration_date(resultSet.getDate(4));

				listRF.add(rf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRF;

	}

	// dang ky hoc
	public RegistrationForm register(RegistrationForm rf) throws SQLException {
		connection = DBConnect.getJDBCConnection();
		preparedStatement = null;
		String sql = "insert into student_management.registration_form values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, rf.getCourse_id());
			preparedStatement.setString(2, rf.getStudent_code());
			preparedStatement.setString(3, rf.getSemester());
			preparedStatement.setDate(4, (java.sql.Date) rf.getRegistration_date());
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
			String sql = "select * from student_management.registration where student_code='" + student_code + "'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				rf = new RegistrationForm();

				rf.setCourse_id(resultSet.getString(1));
				rf.setStudent_code(resultSet.getString(2));
				rf.setSemester(resultSet.getString(3));
				

				list.add(rf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return (ArrayList<RegistrationForm>) list;
	}
	
	public boolean kiemTraSanPhamCoTrongGioHangChua(String maSanPham){
		for (int i = 0; i < gioHang.size(); i++) {
			if(gioHang.get(i).getCourse_id().equals(maSanPham)){
				return true;
			}
		}
		return false;
	}
	
	public boolean themVaoGioHang(String maSanPham){
		getListCourse();
		boolean kiemTra = kiemTraSanPhamCoTrongGioHangChua(maSanPham);
		for (int i = 0; i <listCourse.size(); i++) {
				if(listCourse.get(i).getCourse_id().equals(maSanPham) && kiemTra==false){
					gioHang.add(listCourse.get(i));
					return true;
				}
		}
		return false;
	}
	public boolean xoaSanPhamRaKkoiGioHang(String maSanPham){
		for (int i = 0; i < gioHang.size(); i++) {
			if(gioHang.get(i).getCourse_id().equals(maSanPham)){
				gioHang.remove(i);
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Course> getDsSanPham() {
		return listCourse;
	}

	public static void setDsSanPham(ArrayList<Course> listCourse) {
		ManageStudent.listCourse = listCourse;
	}

	public static ArrayList<Course> getGioHang() {
		return gioHang;
	}

	public static void setGioHang(ArrayList<Course> gioHang) {
		ManageStudent.gioHang = gioHang;
	}


	public static void main(String[] args) throws SQLException {
		ManageStudent ms = new ManageStudent();
//		RegistrationForm rf = new RegistrationForm("2", "2", "1", new java.sql.Date(2019 - 8 - 14));
//		System.out.println(ms.getListStudent());
//		System.out.println(ms.getListCourse());
//		System.out.println(ms.getAllRegistration());
//		System.out.println(ms.checkLogin("17130197", "123"));
//		ms.register(rf);
//		System.out.println(ms.getByStudent_code("2"));
//		ms.themVaoGioHang("214252");
//		System.out.println(ms.gioHang);
//		System.out.println(ms.mapStudent.get("17130198"));
	}
}
