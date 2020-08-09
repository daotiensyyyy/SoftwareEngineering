package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import utils.AppUtils;
import utils.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

<<<<<<< HEAD
		if (userAccount.getUserName() == null) {
=======
		User user = new UserDAO().checkLogin(userName, password);

		if (user.getUsername() == null) {
>>>>>>> d4de686dc3b9d31c4fdd3d3bdbd933cd6e11ad97
			String errorMessage = "Tên đăng nhập hoặc mật khẩu không đúng";
			request.setAttribute("errorMessage", errorMessage);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		} else {
			AppUtils.storeLoginedUser(request.getSession(), user);
			//
			int redirectId = -1;
			try {
				redirectId = Integer.parseInt(request.getParameter("redirectId"));
			} catch (Exception e) {
			}
			String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
			if (requestUri != null) {
				response.sendRedirect(requestUri);
			} else {
				// Mặc định sau khi đăng nhập thành công
				// chuyển hướng về trang /home
//				request.getRequestDispatcher("/index.jsp").forward(request, response);
				response.sendRedirect("/STM/");
			}
		}

	}
}
