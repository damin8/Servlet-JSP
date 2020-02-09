package com.Damin.web.entity;

public class Notice {
	private int id;
	private String title;
	private String writerId;
	private String regdate;
	private int hit;
	private String files;
	private String content;
	
	
	
	public Notice(int id, String title, String writerId, String regdate, int hit, String files, String content) {
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getWriterId() {
		return writerId;
	}



	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	public int getHit() {
		return hit;
	}



	public void setHit(int hit) {
		this.hit = hit;
	}



	public String getFiles() {
		return files;
	}



	public void setFiles(String files) {
		this.files = files;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}
	
}
