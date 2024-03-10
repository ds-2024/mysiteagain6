package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 등록
	public int addGuestbook(GuestbookVo guestbookVo) {

		System.out.println("GuestbookDao.addGuestbook()");
		System.out.println(guestbookVo);

		int count = sqlSession.insert("guestbook.addGuestbook", guestbookVo);
		System.out.println(count);// count 위치 중요

		return count;

	}

	// 리스트
	public List<GuestbookVo> guestList() {

		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.select");

		return guestbookList;
	}

}
