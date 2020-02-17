package com.Damin.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.Damin.web.entity.Notice;

public class DetailService {
	public Notice getNotice(int Uid) {
		Notice notice = null;
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url,"root","emforhsqhf1");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, Uid);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("ID");
				String content = rs.getString("CONTENT");
				String files = rs.getString("FILES");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String title = rs.getString("TITLE");
				notice = new Notice(
						id,
						title,
						writerId, 
						regdate,
						hit,
						files,
						content
						);
			}
		    rs.close();
		    st.close();
		    conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getPrevNotice(int Uid) {
		Notice notice = null;
		String sql = "SELECT * FROM " + 
				"(SELECT  @ROWNUM:=@ROWNUM+1 AS ROWNUM , A.* FROM " + 
				"(SELECT * FROM NOTICE ORDER BY REGDATE DESC) A, (SELECT @ROWNUM := 0)R " + 
				"WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?))DAMIN " + 
				"WHERE ROWNUM = 1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url,"root","emforhsqhf1");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, Uid);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("ID");
				String content = rs.getString("CONTENT");
				String files = rs.getString("FILES");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String title = rs.getString("TITLE");
				notice = new Notice(
						id,
						title,
						writerId, 
						regdate,
						hit,
						files,
						content
						);
			}
		    rs.close();
		    st.close();
		    conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getNextNotice(int Uid) {
		Notice notice = null;
		String sql = "SELECT * FROM " + 
				"(SELECT  @ROWNUM:=@ROWNUM+1 AS ROWNUM , A.* FROM " + 
				"(SELECT * FROM NOTICE) A, (SELECT @ROWNUM := 0)R " + 
				"WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID = ?)) DAMIN " + 
				"WHERE ROWNUM = 1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url,"root","emforhsqhf1");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, Uid);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("ID");
				String content = rs.getString("CONTENT");
				String files = rs.getString("FILES");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String title = rs.getString("TITLE");
				notice = new Notice(
						id,
						title,
						writerId, 
						regdate,
						hit,
						files,
						content
						);
			}
		    rs.close();
		    st.close();
		    conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
}
