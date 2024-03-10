package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	// 등록
	@RequestMapping(value = "/guestbook/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add()");
		System.out.println(guestbookVo);

		guestbookService.exeAdd(guestbookVo);

		return "redirect:/guestbook/addlist";
	}

	// 전체리스트 가져오기
	@RequestMapping(value = "/guestbook/addlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestbookController.addlist()");

		List<GuestbookVo> guestbookList = guestbookService.exeList(); //그릇이름 음식(게스트북서비스의 리스트호출한 결과)을 담은 그릇
		model.addAttribute("guestbookList", guestbookList);
		
		return "/guestbook/addList";

	}
	
	//삭제폼
	@RequestMapping(value = "/guestbook/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestDeleteForm() {
		System.out.println("GuestbookController.guestDeleteForm()");
		
		return "/guestbook/deleteForm";
	}
	
	//삭제
	@RequestMapping(value = "/guestbook/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestDelete(GuestbookVo guetbookVo) {
		System.out.println("GuestbookController.guestDelete()");
		
		return "";
		
		
	}
}
