package com.Damin.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Damin.web.entity.Notice;

public class NoticeService {
	public int removeNoticeAll(int[] ids) {
		return 0;
	}

	public int pubNoticeAll(int[] ids) {
		return 0;
	}

	public int insertNotice(Notice notice) {
		return 0;
	}

	public int deleteNotice(int id) {
		return 0;
	}

	public int updateNotice(Notice notice) {
		return 0;
	}

	public List<Notice> getNoticeNewestList() {
		return null;
	}

	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}

	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
	}

	public List<Notice> getNoticeList(String field, String query, int page) {
		List<Notice> NoticeList = new ArrayList<>();
		String sql = "SELECT * FROM ( " + "SELECT @ROWNUM:=@ROWNUM+1 AS ROWNUM, N.* FROM "
				+ "(SELECT * FROM NOTICE WHERE " + field + " LIKE ? ORDER BY REGDATE DESC) "
				+ "N, (SELECT @ROWNUM := 0)R ) NN " + " WHERE ROWNUM BETWEEN ? AND ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url, "root", "emforhsqhf1");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1 + (page - 1) * 10);
			st.setInt(3, page * 10);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String content = rs.getString("CONTENT");
				String files = rs.getString("FILES");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String title = rs.getString("TITLE");
				Notice notice = new Notice(id, title, writerId, regdate, hit, files, content);
				NoticeList.add(notice);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NoticeList;
	}

	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {
		int count = 0;
		String sql = "SELECT COUNT(ID) AS COUNT FROM " + "(SELECT @ROWNUM:=@ROWNUM+1 AS ROWNUM, N.* FROM "
				+ "(SELECT * FROM NOTICE WHERE " + field + " LIKE ? ORDER BY REGDATE DESC) N, "
				+ "(SELECT @ROWNUM := 0)R ) NN";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url, "root", "emforhsqhf1");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();
			if (rs.next())
				count = rs.getInt("COUNT");
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int deletNoticeAll(int[] ids) {
		int result = 0;
		String params = "";
		for (int i = 0; i < ids.length; i++) {
			params+=ids[i];
			if (i != ids.length - 1) {
				params+=",";
			}
		}
		Notice notice = null;
		String sql = "DELETE NOTICE WHERE ID IN ("+params+")";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url, "root", "emforhsqhf1");
			Statement st = conn.createStatement();
			result = st.executeUpdate(sql);
			
			st.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
