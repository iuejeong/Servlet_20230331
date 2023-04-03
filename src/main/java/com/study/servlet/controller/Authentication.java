package com.study.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.study.servlet.dto.RequestDto;
import com.study.servlet.dto.ResponseDto;
import com.study.servlet.entity.User;
import com.study.servlet.service.UserService;
import com.study.servlet.service.UserServiceImpl;

@WebServlet("/auth")
public class Authentication extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private Gson gson;
	
	public Authentication() {
		userService = UserServiceImpl.getInstance();
		gson = new Gson();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Request 안에 들어있는 Json을 객체로 전환
		User user = RequestDto.<User>convertRequestBody(request, User.class);
		
		boolean duplicatedFlag = userService.duplicatedUsername(user.getUsername());
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(duplicatedFlag) {
			// true == 중복, false == 가입 가능
			ResponseDto<Boolean> responseDto = new ResponseDto<Boolean>(400, "duplicated username", duplicatedFlag);
			out.println(gson.toJson(responseDto));
			return;
		}
		
		ResponseDto<Integer> responseDto = new ResponseDto<Integer>(201, "signup", userService.addUser(user));
		out.println(gson.toJson(responseDto));
		return;
	}

}
