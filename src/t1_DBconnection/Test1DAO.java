package t1_DBconnection;

import java.sql.DriverManager;

import java.sql.SQLException;

// DB 연결및 DB의 각종 처리를 담당
public class Test1DAO {
	public Test1DAO() {
		try {
			// 1. JDBC 드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공!!!");
			
			// 2. DB서버에 연결하기(만들어놓은 데이터베이스에 연결하기)
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~~" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패~~~" + e.getMessage());
		} finally {
			System.out.println("작업끝....");
		}
	}
}
