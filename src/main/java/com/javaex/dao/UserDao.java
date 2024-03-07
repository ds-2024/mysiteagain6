package com.javaex.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;



@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo userSelectByIdPw(UserVo userVo) {//넘긴거 처리
		System.out.println("UserDao.userSelectByIdPw()");
		System.out.println(userVo);
		
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo); /* "namespace.id" */
		System.out.println(authUser);
		
		
		return authUser;
		
	}
	
	
	
	
	}


