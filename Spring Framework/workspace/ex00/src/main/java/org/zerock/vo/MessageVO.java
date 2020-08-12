package org.zerock.vo;

public class MessageVO {

	private int mid;
	private String targetid; //회원아이디=>외래키
	private String sender; //메시지를 보낸 사람
	private String message; //보낸 메시지
	private String senddate; //메시지를 보낸 날짜
	
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTargetid() {
		return targetid;
	}
	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}	
}
