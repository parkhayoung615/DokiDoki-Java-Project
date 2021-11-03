package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 일단 기능반 서버로 해둠 ...
		// 나중에 바꾸든지 상의를 해야 할 듯
		String connectionString = "jdbc:mysql://www.yydhsoft.com/skills07";
		String userId = "skills07";
		String password = "1234";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(connectionString, userId, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return con;
		
	}
}
