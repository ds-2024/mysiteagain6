package com.javaex.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin()");
		
		UserVo authUser = userDao.userSelectByIdPw(userVo);// 넘기기 받아와서는 UserVo authUser 한테 넘기기
		
		
		return authUser;
	
	}
	
	
	
	
		
}


