package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.UserVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	//등록
	public int exeAdd(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeAdd()");
		System.out.println(guestbookVo);
		//guestbookDao.addGuestbook(guestbookVo);요청문
		
		int count  = guestbookDao.addGuestbook(guestbookVo);
		
		System.out.println(count);
		
		return count; //출력이 안되면 세이브 했는지 의심해라..잘했는데 안되면 껐다가 다시 켜. 자꾸 뒤로가지말고.
	}

}
