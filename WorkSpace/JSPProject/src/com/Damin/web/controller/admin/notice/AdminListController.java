package com.Damin.web.controller.admin.notice;

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
import com.Damin.web.service.NoticeService;

@WebServlet("/admin/board/notice/list")
public class AdminListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		String page = request.getParameter("p");
		if(field == null || field.equals("")) {
			field = "title";
		}
		if(query == null || query.equals("")) {
			query = "";
		}
		if(page==null || page.equals("")) {
			page = "1";
		}
		NoticeService service = new NoticeService();
		int count = service.getNoticeCount(field,query);
		List<Notice> list = service.getNoticeList(field,query,Integer.parseInt(page));
		request.setAttribute("nl", list);
		request.setAttribute("count", count);
		request.
		getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").
		forward(request, resp );
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id"); // 여러 가지 값 받기
		String[] delIds = request.getParameterValues("del-id"); // 여러 가지 값 받기
		String cmd = request.getParameter("cmd");
		int[] ids = new int[openIds.length];
		for(int i=0;i<openIds.length;i++)
			ids[i] = Integer.parseInt(openIds[i]);
		NoticeService service = new NoticeService();
		int result = service.deletNoticeAll(ids);
		response.sendRedirect("list");
	}
}
