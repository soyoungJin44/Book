package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorSelectOne {

	public static void main(String[] args) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과값 들어갈 그릇
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩

			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기

			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비 / 바인딩 / 실행

			String query = "";
			query += " select author_id ";
			query += "		,author_name ";
			query += "		,author_desc ";
			query += " from author ";
			query += " where author_id = ? ";

			// 바인딩
			// :
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 1);

			// 실행

			rs = pstmt.executeQuery();

			// 결과처리
			rs.next(); 		//한줄 꼭 내려주기
			int id = rs.getInt("author_id"); // int형 숫자들 중 뭘 가져올거냐
			String name = rs.getString("author_name");
			String desc = rs.getString("author_desc");

			AuthorVo authorVo = new AuthorVo(id,name,desc);
			System.out.println(authorVo);
			System.out.println(authorVo.getName());
			
			/*  한개로 묶어주기
			System.out.println(id);
			System.out.println(name);
			System.out.println(desc);
			*/
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
