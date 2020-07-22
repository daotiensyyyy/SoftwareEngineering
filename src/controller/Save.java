package controller;

import java.io.IOException;
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
import dao.ManageStudent;

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
		HttpSession session = request.getSession();
		String course_id = request.getParameter("course_id");
		String course_name = request.getParameter("course_name");
		String credits = request.getParameter("credits");
		String day = request.getParameter("day");
		String room = request.getParameter("room");
		String semester = request.getParameter("semester");
		RegistrationForm rf = new RegistrationForm(course_id, student_code, semester, registration_date)
		stm.register(rf);
		// List<TourItem> list = new TourDAOImp().getList();
		// request.setAttribute("list", list);
		request.getRequestDispatcher("").forward(request, response);
	}

}
