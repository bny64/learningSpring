package com.bny.dto;

public class Comment {
	
	private int listNo;
	private String id;
	private String name;
	private String contents;
	private char searchYn;
	private int parListNo;
	public int getListNo() {
		return listNo;
	}
	public void setListNo(int listNo) {
		this.listNo = listNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public char getSearchYn() {
		return searchYn;
	}
	public void setSearchYn(char searchYn) {
		this.searchYn = searchYn;
	}
	public int getParListNo() {
		return parListNo;
	}
	public void setParListNo(int parListNo) {
		this.parListNo = parListNo;
	}
}
