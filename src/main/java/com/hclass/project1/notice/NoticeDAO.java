package com.hclass.project1.notice;

public class NoticeDAO {

<<<<<<< Updated upstream
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hclass.project1.notice.NoticeDTO;
import com.hclass.project1.util.Pager;


@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace="com.hclass.project1.notice.NoticeDAO.";
	
	public List<NoticeDTO> noticeList(Pager pager) throws Exception {
		 return sqlSession.selectList(namespace+"noticeList",pager);
	}
	
	public NoticeDTO noticeSelect(long num) throws Exception {
		return sqlSession.selectOne(namespace+"noticeSelect", num);
	}
	
	public long noticeCount(Pager pager)throws Exception{
		return sqlSession.selectOne(namespace+"noticeCount", pager);
	}

=======
>>>>>>> Stashed changes
}
