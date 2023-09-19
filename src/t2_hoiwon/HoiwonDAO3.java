package t2_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoiwonDAO3 {
	Connection conn = null;
public HoiwonDAO3() {
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
			
			System.out.println("\t\t** 주 소 록 **");
			System.out.println("=".repeat(42));
			System.out.println("번호\t성명\t나이\t주소\t성별");
			System.out.println("=".repeat(42));
			
			while(rs.next()) {
				System.out.print(rs.getString("idx") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("age") + "\t");
				System.out.print(rs.getString("address") + "\t");
				System.out.print(rs.getString("gender"));
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		}	
	}
}