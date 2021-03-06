package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManageStudent;
import model.Course;

@WebServlet("/Search")
public class Search extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_id = request.getParameter("course_id");
		ArrayList<Course> dsLoc = new ManageStudent().filterList(course_id);
		if(dsLoc.isEmpty()) {
			String message = "Không có môn học được mở";
			request.setAttribute("message", message);
		}
		List<Course> list_cart = new ManageStudent().getTmp();
		request.setAttribute("lstCart", list_cart);
		request.setAttribute("list", dsLoc);
		request.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
	}
}
