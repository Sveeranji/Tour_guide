package com.marolix.traveling.dto;


public class ReviewDto {

	
	private String text;
	
	private String num;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "ReviewDto [text=" + text + ", num=" + num + "]";
	}

	public ReviewDto(String text, String num) {
		super();
		this.text = text;
		this.num = num;
	}

	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
