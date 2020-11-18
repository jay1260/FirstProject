package com.hclass.project1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hclass.project1.util.Pager;

@Repository
public class NoticeDAO {

   @Autowired
   private SqlSession sqlSession;
   private final String namespace="com.hclass.porject1.notice.NoticeDAO.";

   public List<NoticeDTO> getList(Pager pager) throws Exception{
      return sqlSession.selectList(namespace+"getList",pager);
   }

   public int setOne(NoticeDTO noticeDTO) throws Exception {
      return sqlSession.insert(namespace+"setOne",noticeDTO);
   }
   public long getCount(Pager pager) throws Exception {
      return sqlSession.selectOne(namespace+"getCount", pager);
   }
   
   public int noticeWrite(NoticeDTO noticeDTO)throws Exception{
      return sqlSession.insert(namespace+"noticeWrite", noticeDTO);
   }
}