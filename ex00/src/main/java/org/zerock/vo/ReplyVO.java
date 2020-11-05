package org.zerock.vo;

public class ReplyVO { //데이터 저장빈 클래스
/* 되도록이면 tbl_reply테이블의 컬렴명과 빈클래스 변수명을 일치시킨다.
 */
	private int rno; //댓글번호
	private int bno; //종속키 게시물번호
	private String replyer; //댓글 작성자
	private String replytext; //댓글 내용
	private String regdate; //댓글 등록날짜
	private String updatedate; //댓글 수정날짜
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
}
