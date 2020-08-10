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

import dao.ManageStudent;
import model.Course;
import model.User;
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
		HttpSession session = request.getSession();
		User user = AppUtils.getLoginedUser(session);
		//kiem tra da dang nhap chua
		if (user != null) {
//			System.out.println(user);
			List<Course> list = stm.getListCourse();

			request.setAttribute("lstCourse", list);
			request.getRequestDispatcher("/WEB-INF/views/courseRegister.jsp").forward(request, response);
		} else {
			//chua dang nhap quay lai trang dang nhap
			response.sendRedirect("login");
		}

	}
}
