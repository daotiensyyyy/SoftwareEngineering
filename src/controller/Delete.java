package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.ManageStudent;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageStudent stm;
	
    public Delete() {
    	stm = new ManageStudent();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_id = request.getParameter("course_id");
		List<Course> list = stm.getListCourse();
			List<Course> list_cart = stm.getTmp();
//			System.out.println(list);
			request.setAttribute("lstCart", list_cart);
//			System.out.println(list);
		request.setAttribute("lstCourse", list);
		stm.delete(course_id);
		request.getRequestDispatcher("/WEB-INF/views/courseRegister.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
