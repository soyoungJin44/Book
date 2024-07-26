package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//딜리트

public class AuthorDelete {

	public static void main(String[] args) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		// 1. JDBC 드라이버 (Oracle) 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
			
		// 2. Connection 얻어오기
		
		String url = "jdbc:mysql://localhost:3306/book_db";
		conn = DriverManager.getConnection(url, "book", "book");
		
		// 3. SQL문 준비 / 바인딩 / 실행
		
		String query = "";
		query += "delete from author ";
		query += " where author_id = ?";
		
		//바인딩
		
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, 10);
	
		
		// 실행
		
		int count = pstmt.executeUpdate();
		System.out.println(count + "건 지워졌습니다.");
		
		// 4.결과처리
		} catch (ClassNotFoundException e) {
		System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		System.out.println("error:" + e);
		} finally {
		// 5. 자원정리
		try {
		if (rs != null) {
		rs.close();
		}
		if (pstmt != null) {
		pstmt.close();
		}
		if (conn != null) {
		conn.close();
		}
		} catch (SQLException e) {
		System.out.println("error:" + e);
		}
		}	
		
		
	}

}
