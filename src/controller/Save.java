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

import bean.Course;
import bean.RegistrationForm;
import bean.Student;
import bean.UserAccount;
import dao.ManageStudent;
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
			UserAccount user = AppUtils.getLoginedUser(session);
			String student_code = String.valueOf(user);
//			String student_code = (String) session.getAttribute("userAcount");
			String course_id = request.getParameter("cart_course_id");
			String course_name = request.getParameter("cart_course_name");
			String day = request.getParameter("cart_day");
			String room = request.getParameter("cart_room");
			String semester = request.getParameter("cart_semester");
			String start_time = request.getParameter("cart_start");
			String end_time = request.getParameter("cart_end");
			RegistrationForm rf = new RegistrationForm(student_code, course_id, course_name, day, room, semester,
					start_time, end_time);
			stm.register(rf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Course");
	}

}
