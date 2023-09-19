package t7_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoiwonDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	HoiwonVO vo = null;
	
	public HoiwonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			//String url = "jdbc:mysql://127.0.0.1:3306/javaProject";
			//String url = "jdbc:mysql://192.168.50.20:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다." + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동실패~" + e.getMessage());
		}
	}
	
	// conn객체 close
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	// stmt객체 close
	public void stmtClose() {
		try {
			if(stmt != null) stmt.close();
		} catch (SQLException e) {}
	}
	
	// rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			stmtClose();
		} catch (Exception e) {}
	}

	// 전체 회원 조회
	public ArrayList<HoiwonVO> getList() {
		ArrayList<HoiwonVO> vos = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoiwon order by idx desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo = new HoiwonVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			//System.out.println("SQL 문장 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}

	// 개별 회원 조회
	public HoiwonVO getSearch(String name) {
		HoiwonVO vo = new HoiwonVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoiwon where name = '"+name+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 회원자료 삭제하기
	public void setDelete(String name) {
		try {
			stmt = conn.createStatement();
			sql = "delete from hoiwon where name = '"+name+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
	}

	// 삭제(리턴타입을 정수형변수로 처리한 경우)
	public int setDelete2(String name) {
		int res = 0;
		try {
			Statement stmt = conn.createStatement();
			sql = "delete from hoiwon where name = '"+name+"'";
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		}
		return res;
	}

	// 회원 가입 처리(sql문 : insert)
	// public void setHoiwonInput(String name, int age, String address, int gender) {
	public int setHoiwonInput(HoiwonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoiwon values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getAddress()+"','"+vo.getGender()+"')";
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
		return res;
	}

	// 자료 수정(sql문 : update)
	public int setHoiwonUpdate(String name, int age, String address, String strGender) {
		int res = 0;
		
		try {
			sql = "update hoiwon set age="+age+", address='"+address+"', gender='"+strGender+"' where name='"+name+"'";
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
		
		return res;
	}
	
}
