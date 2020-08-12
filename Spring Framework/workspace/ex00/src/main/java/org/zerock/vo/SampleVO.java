package org.zerock.vo;

public class SampleVO {
	
	private int mno; //변수명이 JSON의 키이름이 된다.
	private String firstName; //성
	private String lastName; //이름
	
	
	public int getMno() { //값 반환 메서드 => getter() 메서드라고 한다.
		return mno;
	}
	public void setMno(int mno) { //값 저장 메서드 => setter() 메서드라고 한다.
		this.mno = mno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
