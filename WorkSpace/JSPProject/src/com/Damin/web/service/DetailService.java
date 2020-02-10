package com.Damin.web.service;

import com.Damin.web.entity.Notice;

public class DetailService {
	public Notice getNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		return null;
	}
	public Notice getPrevNotice(int id) {
		return null;
	}
	public Notice getNextNotice(int id) {
		String sql = "SELECT * FROM NOTICE "
				+ "WHERE ID = ( "
				+ " SELECT ID FROM NOTICE "
				+ " WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=3) "
				+ " AND ROWNUM = 1 )";
		return null;
	}
}
