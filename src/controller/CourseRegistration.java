package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Course;
import bean.User;
import bean.UserAccount;
import dao.ManageStudent;
import utils.AppUtils;
import utils.UserDAO;

@WebServlet(urlPatterns = "/Course")
public class CourseRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageStudent stm;

	public CourseRegistration() {

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
//		request.getRequestDispatcher("/WEB-INF/views/courseRegister.jsp").forward(request, response);
		HttpSession session = request.getSession(false);
		UserAccount user = AppUtils.getLoginedUser(session);
//		System.out.println(user);
//		System.out.println(session);
		if (user != null) {
			System.out.println(user);
			List<Course> list = stm.getListCourse();
			String course_id = request.getParameter("course_id");
			// System.out.println(course_id);
			stm.insert(course_id);
			List<Course> list_cart = stm.getTmp();
//			System.out.println(list);
			request.setAttribute("lstCart", list_cart);
//			System.out.println(list);
			request.setAttribute("lstCourse", list);
			request.getRequestDispatcher("/WEB-INF/views/courseRegister.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}

	}
}
