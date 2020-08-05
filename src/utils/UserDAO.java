package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import connection.DBConnect;

public class UserDAO {
	public User checkLogin(String user, String pass) {
		try {
			String query = " SELECT * FROM `user` WHERE username =? AND password=?;";
			PreparedStatement preparedStatement = DBConnect.getPreparedStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			ResultSet rs = preparedStatement.executeQuery();

			User userAccount = new User();
			while (rs.next()) {
				userAccount.setId(rs.getString(1));
				userAccount.setFirstname(rs.getString(2));
				userAccount.setLastname(rs.getString(3));
				userAccount.setAddress(rs.getString(4));
				userAccount.setEmail(rs.getString(5));
				userAccount.setBirthday(rs.getDate(6));
				userAccount.setPhone(rs.getString(7));
				userAccount.setUsername(rs.getString(8));
				userAccount.setPassword(rs.getString(9));
				userAccount.setRole(rs.getString(10));
				userAccount.setStatus(rs.getString(11));
			}
			System.out.println(userAccount);
			return userAccount;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

//	public static void main(String[] args) {
//		UserDAO ud = new UserDAO();
//		System.out.println(ud.checkLogin("17130084", "123456").getUsername());
//	}
}
