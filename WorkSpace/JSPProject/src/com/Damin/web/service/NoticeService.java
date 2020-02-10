package com.Damin.web.service;

import java.util.List;

import com.Damin.web.entity.Notice;

public class NoticeService {
	public List<Notice> getNoticeList(){
		return getNoticeList("title","",1);
	}
	public List<Notice> getNoticeList(int page){
		return getNoticeList("title","",page);
	}
	public List<Notice> getNoticeList(String field, String query, int page){
		String sql = "SELECT * FROM ("
				+ " SELECT ROWNUM NUM, N.* "
				+ " FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"
				+ ") "
				+ "WHERE NUM BETWEEN 6 AND 10";
		return null;
	}
	public int getNoticeCount() {
		return getNoticeCount("title","");
	}
	public int getNoticeCount(String field, String query) {
		String sql = "SELECT * FROM ("
				+ " SELECT ROWNUM NUM, N.* "
				+ " FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"
				+ ") "
				+ "WHERE NUM BETWEEN 6 AND 10";
		return 0;
	}
}
