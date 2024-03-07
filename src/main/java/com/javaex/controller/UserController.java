package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService; //대소문자 주의!!
	
	//로그인
	@RequestMapping(value = "/user/login", method = {RequestMethod.GET, RequestMethod.POST} )
	public String login(HttpSession session, @ModelAttribute UserVo userVo) {
		System.out.println("UserController.login()");
		
		UserVo authUser = userService.exeLogin(userVo);
		System.out.println(authUser);
		
		
		
		if (authUser == null) {
	        // 인증 실패 시 로그인 폼으로 이동
	        return "redirect:/user/loginForm"; 
	    } else {
	        // 세션에 올리기
	        session.setAttribute("authUser", authUser);
	        return "redirect:/main";
	    }
		
		
	}
	
	//로그인폼
	@RequestMapping(value = "/user/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginform() {
		System.out.println("UserController.loginform()");
		
		return "user/loginForm";
		
	
	}

}
