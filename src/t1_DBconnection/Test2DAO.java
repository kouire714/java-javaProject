package t1_DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test2DAO {
	Connection conn = null;
	
	public Test2DAO() {
		try {
			// 1. 드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			
		}	catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색실패" + e.getMessage());
		}
			catch (SQLException e) {
			System.out.println("데이터베이스 연결실패" + e.getMessage());
		}
		
	}
	
	// conn 객체 close
	public void connClose() {
		try {
			conn.close();
			System.out.println("conn객체가 닫혔습니다. ");
		} catch (SQLException e) {}
		
	}
}
