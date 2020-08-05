package utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.User;

public class AppUtils {
	private static int REDIRECT_ID = 0;

	private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();

	// Lưu trữ thông tin người dùng vào Session.
	public static void storeLoginedUser(HttpSession session, User loginedUser) {
		// Trên JSP có thể truy cập thông qua ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
	}

	// Lấy thông tin người dùng lưu trữ trong Session.
	public static User getLoginedUser(HttpSession session) {
		User loginedUser = (User) session.getAttribute("loginedUser");
		return loginedUser;
	}

	public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
		String url = id_uri_map.get(redirectId);
		if (url != null) {
			return url;
		}
		return null;
	}
}
