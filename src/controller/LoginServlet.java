package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.sax.SAXSource;

import model.User;
import utils.AppUtils;
import utils.CaptchaUtils;
import utils.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int count = 0;

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
        // lay thong tin mssv và password
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        boolean valid = true;
        String errorMessage = "";

        User user = new UserDAO().checkLogin(userName, password);

        if (user.getUsername() == null && user.getPassword() == null) {
            errorMessage = "Tên đăng nhập hoặc mật khẩu không đúng";
            request.setAttribute("errorMessage", errorMessage);
            request.getSession().setAttribute("captcha", "visible");
            valid = false;
        }

        if (request.getSession().getAttribute("captcha") != null)
            if (valid) {
                String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
                // Verify CAPTCHA.
                valid = CaptchaUtils.verify(gRecaptchaResponse);
                if (!valid)
                    errorMessage = "Chưa xác thực captcha!";
            }

        if (!valid) {
            request.setAttribute("errorMessage", errorMessage);
            request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("loginedUser", user);
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
