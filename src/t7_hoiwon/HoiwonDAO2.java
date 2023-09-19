package t7_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoiwonDAO2 {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	HoiwonVO vo = null;
	
	public HoiwonDAO2() {
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
	
	// pstmt객체 close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {}
	}
	
	// rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmtClose();
		} catch (Exception e) {}
	}

	// 전체 회원 조회
	public ArrayList<HoiwonVO> getList() {
		ArrayList<HoiwonVO> vos = new ArrayList<>();
		try {
			sql = "select * from hoiwon order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
			sql = "select * from hoiwon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
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
			sql = "delete from hoiwon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}

	// 회원 가입 처리(sql문 : insert)
	// public void setHoiwonInput(String name, int age, String address, int gender) {
	public int setHoiwonInput(HoiwonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoiwon values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getGender());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 자료 수정(sql문 : update)
	public int setHoiwonUpdate(String name, int age, String address, String strGender) {
		int res = 0;
		
		try {
			sql = "update hoiwon set age=?, address=?, gender=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, address);
			pstmt.setString(3, strGender);
			pstmt.setString(4, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
		  System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
}
