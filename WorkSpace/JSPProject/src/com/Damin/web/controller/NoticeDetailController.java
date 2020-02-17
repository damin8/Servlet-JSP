package com.Damin.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Damin.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url, "root", "emforhsqhf1");
			String sql = "SELECT * FROM NOTICE WHERE ID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			String content = rs.getString("CONTENT");
			String files = rs.getString("FILES");
			int hit = rs.getInt("HIT");
			String writerId = rs.getString("WRITER_ID");
			Date regdate = rs.getDate("REGDATE");
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
			request.setAttribute("n",notice);
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
	}
}
