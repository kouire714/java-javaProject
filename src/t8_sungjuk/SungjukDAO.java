package t8_sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	SungjukVO vo = null;
	String sql = "";
	
	public SungjukDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";
		
		try {
			// 1.드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.데이터베이스 검색(연결/연동)
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 오류~~" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동실패~~" + e.getMessage());
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
		} catch (Exception e) {}
	}
	
	// rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {}
		pstmtClose();
	}

	// 성적자료 등록처리
	public int setInput(SungjukVO vo) {
		int res = 0;
		
		try {
			sql = "insert into sungjuk values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 전체 조회 처리
	public ArrayList<SungjukVO> getList() {
		ArrayList<SungjukVO> vos = new ArrayList<SungjukVO>();
		
		try {
			sql = "select * from sungjuk order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new SungjukVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	// 개별 조회 처리
	public SungjukVO getSearch(String name) {
		SungjukVO vo = new SungjukVO();
		
		try {
			sql = "select * from sungjuk where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
			}
			else vo = null;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
}
