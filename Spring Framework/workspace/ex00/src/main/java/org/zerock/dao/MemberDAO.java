package org.zerock.dao;


import org.zerock.vo.MemberVO;

public interface MemberDAO {

	void insertM(MemberVO m);//public abstract키워드가 생략된 추상메서드이다.
	//추상메서드는 {}가 없고 실행문장이 없고, 호출불가능.
	
}
