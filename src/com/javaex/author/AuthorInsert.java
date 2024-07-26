package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {

		System.out.println("작가등록 예제");   

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Connection 얻어오기  ** localhost 부분이 ip들어가는부분
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");
			
			// 3. SQL문 준비 / 바인딩 / 실행
			//sql 문 준비 (insert 문을 자바의 문자열로 만들어준다.)  ** 데이터 영역은 ?로 표시
			
			// String query = "insert into author values(null, '기안84', '웹툰작가')";
			
			// 수정 , 체크하기에 훨씬 수월함.
			String query = "";
			query += "insert into author ";
			query += " values(null, ?, ?)"; //띄어쓰기 해줘야함. 
			
					
			//String query = "insert into authorvalues(null, ?, ?)";
			
			// ***** << 바인딩 >> 
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "기안84");
			pstmt.setString(2, "웹툰작가");
			
			// ** 실행 : 
			int count = pstmt.executeUpdate();
			System.out.println(count);   ///확인용
			
			// 4.결과처리
			
			System.out.println(count + "건 등록되었습니다.");
			
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
