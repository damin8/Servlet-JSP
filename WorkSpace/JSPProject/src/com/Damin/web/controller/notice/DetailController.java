package com.Damin.web.controller.notice;

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
import com.Damin.web.service.DetailService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DetailService service = new DetailService();
		Notice notice = service.getNotice(id);
		request.setAttribute("n", notice);
		request.
		getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").
		forward(request, response);
	}
}
