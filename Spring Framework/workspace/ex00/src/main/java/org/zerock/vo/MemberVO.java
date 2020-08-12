package org.zerock.vo;


public class MemberVO {//회원관리 중간 데이터 저장빈 클래스
	
	/* MYBATIS를 사용하려면 되도록 테이블 컬럼명과 빈클래스 변수명을 일치 시키는 것이 좋다. 
	 */
	
	private String userid;//회원아이디
	private String userpw;//회원비번
	private String username;//회원이름
	private String email;//이메일
	private String regdate;//가입날짜
	private String updatedate;//수정날짜
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

