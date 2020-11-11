package com.hclass.project1.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hclass.project1.trainer.MemberTrainerDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.hclass.project1.member.MemberDAO.";
	
	public int setTrainer(MemberTrainerDTO membertrainerDTO) throws Exception{
		
		return sqlSession.insert(namespace+"setTrainer",membertrainerDTO);
	}
	
	public int setOne(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.insert(namespace+"setOne",memberDTO);
	}
	
	public MemberDTO getOne(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.selectOne(namespace+"getOne",memberDTO);
	}
		public MemberDTO getEmail(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.selectOne(namespace+"getEmail",memberDTO);
	}
	public MemberDTO getPhone(MemberDTO memberDTO) throws Exception{
	
		return sqlSession.selectOne(namespace+"getPhone",memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(namespace+"memberLogin",memberDTO);
	}
	
}
