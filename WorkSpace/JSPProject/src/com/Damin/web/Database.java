package com.Damin.web;

import java.sql.*;

public class Database {
	public void DoIt() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/Servlet";
			Connection conn = null;
			conn = DriverManager.getConnection(url,"Damin","1234");
			String sql = "SELECT * FROM NOTICE";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
