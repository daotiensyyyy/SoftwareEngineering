package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import constants.Constants;

public class DBConnect extends Constants{
	private static Connection con;
	private static String url = URL;
	private static String user = USER;
	private static String password = PASSWORD;

	public DBConnect() {
	}

	public static Connection getJDBCConnection() {

		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}


	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		if (con == null || con.isClosed()) {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(url, user, password);
		}
		return con.prepareStatement(sql);
	}

	public static void main(String[] args) throws Exception {
		DBConnect database = new DBConnect();
		Connection connection = database.getJDBCConnection();
		if (connection != null) {
			System.out.println("Connected!!!!");
		} else {
			System.out.println("Failed!!!!");
		}

	}

	public void doSQLScript(String sql) throws Exception {
		Connection connect = getJDBCConnection();
		Statement stmt = (Statement) connect.createStatement();
		stmt.executeUpdate(sql);
	}

	public ResultSet selectFromDatabase(String sql) throws Exception {
		Connection connect = getJDBCConnection();
		Statement stmt = (Statement) connect.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}

	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
