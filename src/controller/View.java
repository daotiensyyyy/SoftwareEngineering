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
import bean.RegistrationForm;
import bean.User;
import bean.UserAccount;
import dao.ManageStudent;
import utils.AppUtils;
import utils.UserDAO;

@WebServlet(urlPatterns = "/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageStudent stm;

	public View() {

		stm = new ManageStudent();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAccount user = AppUtils.getLoginedUser(session);
		String student_code = String.valueOf(user);
		List<RegistrationForm> list = stm.getByStudent_code(student_code);
	
		request.setAttribute("lst", list);
		request.getRequestDispatcher("/WEB-INF/views/selected.jsp").forward(request, response);

	}
}
