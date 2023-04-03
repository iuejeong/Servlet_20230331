//package com.study.servlet.controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletInputStream;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.study.servlet.entity.User;
//import com.study.servlet.service.UserService;
//import com.study.servlet.service.UserServiceImpl;
//
//@WebServlet("/auth")
//public class ServletStudy extends HttpServlet {
//	
//	private static final long serialVersionUID = 1L;
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		
//		List<User> userList = new ArrayList<>();
//		userList.add(new User("aaa", "1234", "a", "aaa@gmail.com"));
//		userList.add(new User("bbb", "1234", "b", "bbb@gmail.com"));
//		userList.add(new User("ccc", "1234", "c", "ccc@gmail.com"));
//		userList.add(new User("ddd", "1234", "d", "ddd@gmail.com"));
//
//		User findUser = null;
//		
//		for(User user : userList) {
//			if(user.getUsername().equals(username)) {
//				findUser = user;
//				break;
//			}
//		}
//		
//		Gson gson = new Gson();
//		
//		String userJson = gson.toJson(findUser);
//		response.setContentType("application/json;charset=UTF-8");
//		response.getWriter().println(userJson);
//		
////		User user = new User();
////		user.setUsername("aaa");
////		user.setPassword("bbb");
////		user.setName("ccc");
////		user.setEmail("ddd@gmail.com");
////		Map<String, String> userMap = new HashMap<>();
////		userMap.put("username", user.getUsername());
////		userMap.put("password", user.getPassword());
////		userMap.put("name", user.getName());
////		userMap.put("email", user.getEmail());
////		String username = request.getParameter("username");
////		String findUser = userMap.get(username);
////		
////		
////		JsonObject responseData = new JsonObject();
////		responseData.addProperty(username, user.getUsername());
////		responseData.addProperty(, user.getPassword());
////		responseData.addProperty(username, user.getName());
////		responseData.addProperty(username, user.getEmail());
////		System.out.println(responseData);
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("application/json;charset=UTF-8");
//		ServletInputStream inputStream = request.getInputStream();
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//		
//		String requestBody = bufferedReader.lines().collect(Collectors.joining());
//		Gson gson = new Gson();
//		User user = gson.fromJson(requestBody, User.class);
//		
//		System.out.println(user);
//		
//		PrintWriter out = response.getWriter();
//		JsonObject responseBody = new JsonObject();
//		
//		if(user == null) {
//			responseBody.addProperty("success", false);
//		}else {
//			responseBody.addProperty("success", true);
//		}
//		out.println(responseBody.toString());
//	}
//
//}
