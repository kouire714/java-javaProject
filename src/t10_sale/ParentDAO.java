package t10_sale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ParentDAO {
	Connection conn = null;
	
	public ParentDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패~~" + e.getMessage());
		}
	}
}
