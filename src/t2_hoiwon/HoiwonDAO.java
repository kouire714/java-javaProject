package t2_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoiwonDAO {
	Connection conn = null;
public HoiwonDAO() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";
		conn = DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 검색 실패~~" + e.getMessage());
	} catch (SQLException e) {
		System.out.println("데이터베이스 연동 실패~~~" + e.getMessage());
	}
}

// conn 객체 close
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}

	// 전체 회원 조회하기
	public void getList() {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from hoiwon";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			System.out.print("번호 : " + rs.getString("idx"));
			System.out.print("성명 : " + rs.getString("name"));
			System.out.print("나이 : " + rs.getString("age"));
			System.out.print("주소 : " + rs.getString("address"));
			System.out.print("성별 : " + rs.getString("gender"));
			System.out.println();
			
			rs.next();
			System.out.print("번호 : " + rs.getString("idx"));
			System.out.print("성명 : " + rs.getString("name"));
			System.out.print("나이 : " + rs.getString("age"));
			System.out.print("주소 : " + rs.getString("address"));
			System.out.print("성별 : " + rs.getString("gender"));
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		}	
	}
}