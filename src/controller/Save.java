package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManageStudent;
import model.Course;
import model.RegistrationForm;
import model.Student;
import model.User;
import utils.AppUtils;

@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageStudent stm;

	public Save() {
		stm = new ManageStudent();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		try {
			HttpSession session = request.getSession();
			User user = AppUtils.getLoginedUser(session);
			String student_code = String.valueOf(user);
			String course_id = request.getParameter("course_id");
			String course_name = request.getParameter("course_name");
			String day = request.getParameter("day");
			String room = request.getParameter("room");
			String time = request.getParameter("time");
			String semester = request.getParameter("semester");
			String start_time = request.getParameter("start");
			String end_time = request.getParameter("end");
			if(stm.checkExist(student_code, course_id, day, time)==false) {
			RegistrationForm rf = new RegistrationForm(student_code, course_id, course_name, day, room, time, semester,
					start_time, end_time);
			System.out.println(rf);
			stm.register(rf);
			response.sendRedirect("Course");
			}else {
				String message = "Môn học đã được chọn !";
				request.setAttribute("message", message);
				request.getRequestDispatcher("Course").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
