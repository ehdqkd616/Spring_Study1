package org.zerock.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void updatePoint(String sender, int point) {
	/* point.xml로 복수개의 값을 전달하고자 할때는 java.util패키지 컬렉션 인터페이스 Map
	 * 을 사용한다.
	 */
		Map<String,Object> pm = new HashMap<>();
		pm.put("sender", sender); //put()메서드로 키, 값 쌍으로 저장.point.xml에서
		//큰따옴표 안에 있는 키이름을 참조해서 값을 가져옴
		pm.put("point", point);
		
		this.sqlSession.update("pointUp", pm);
	}
}


