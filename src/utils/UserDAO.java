package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	
import bean.UserAccount;
import connection.DBConnect;

public class UserDAO {
	public UserAccount checkLogin(String user, String pass) {
		try {
			String query = " SELECT * FROM `user` WHERE username =? AND pass=?;";
			PreparedStatement preparedStatement = DBConnect.getPreparedStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			ResultSet rs = preparedStatement.executeQuery();

			UserAccount userAccount = new UserAccount();
			while (rs.next()) {
				userAccount.setUserName(rs.getString(1));
				userAccount.setPassword(rs.getString(2));
			}
			return userAccount;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
