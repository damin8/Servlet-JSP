package com.Damin.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Damin.web.entity.Notice;

@WebServlet("/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url,"root","emforhsqhf1");
			String sql = "SELECT * FROM NOTICE";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Notice> NoticeList = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String content = rs.getString("CONTENT");
				String files = rs.getString("FILES");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				String regdate = rs.getString("RGEDATE");
				String title = rs.getString("TITLE");
				Notice notice = new Notice(
						id,
						title,
						writerId,
						regdate,
						hit,
						files,
						content
						);
				NoticeList.add(notice);
			}
			request.setAttribute("nl", NoticeList);
		    rs.close();
		    st.close();
		    conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/notice/list.jsp").forward(request, resp );
	}
}
