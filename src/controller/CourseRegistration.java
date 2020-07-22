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

import bean.Course;
import dao.ManageStudent;

@WebServlet(urlPatterns = "/Course")
public class CourseRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageStudent stm;

	public CourseRegistration() {

		stm = new ManageStudent();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Course> list = stm.getListCourse();
		String course_id  = request.getParameter("course_id");
		//	System.out.println(course_id);
			stm.themVaoGioHang(course_id);
			List<Course> list_cart = stm.getGioHang();
//			System.out.println(list);
			request.setAttribute("lstCart", list_cart);
//			System.out.println(list);
		request.setAttribute("lstCourse", list);
		request.getRequestDispatcher("/WEB-INF/views/courseRegister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/courseRegister.jsp").forward(request, response);

	}

}
