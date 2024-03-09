package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	//등록
	@RequestMapping(value = "/guestbook/add", method = {RequestMethod.GET, RequestMethod.POST} )
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add()");
		System.out.println(guestbookVo);
		
		guestbookService.exeAdd(guestbookVo);
		
		return "redirect:/guestbook/addlist";
	}
	//전체리스트 가져오기
	@RequestMapping(value = "/guestbook/addlist", method = {RequestMethod.GET, RequestMethod.POST} )
	public String addlist() {
		System.out.println("GuestbookController.addlist()");
		
		
		
		return "guestbook/addList";
	}
}
