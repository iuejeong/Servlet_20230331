package com.study.servlet.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/car")
public class CarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> carMap = new HashMap<>();
		carMap.put("1", "쏘나타");
		carMap.put("2", "K5");
		carMap.put("3", "SM6");
		
		String id = request.getParameter("id");
		String findModel = carMap.get(id);

		JsonObject responseDate = new JsonObject();
		if(findModel == null) {
			responseDate.addProperty("statusCode", 400);
			responseDate.addProperty("errorMessage", "Not Found!!");
		}else {
			responseDate.addProperty("id", id);
			responseDate.addProperty("model", findModel);
		}
		
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(responseDate.toString());
		
		
//		Gson gson = new Gson();
//		
//		String id = request.getParameter("id");
//		String model = request.getParameter("model");
//
//		
//		Map<String, String> carMap = new HashMap<>();
//		carMap.put("id", id);
//		carMap.put("model", model);
//		
//		
//		
//		
//		String carJson = gson.toJson(carMap);
//		response.setContentType("application/json;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println(carJson);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletInputStream inputStream = request.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		
		String requestJson = bufferedReader.lines().collect(Collectors.joining());

		Gson gson = new Gson();
		List<Map<String, String>> requestData = gson.fromJson(requestJson, List.class);
		
		PrintWriter out = response.getWriter();
		
		requestData.forEach(obj -> {
			System.out.println("id(" + obj.get("id") + "): " + obj.get("model"));
			out.println("id(" + obj.get("id") + "): " + obj.get("model"));
		});
		
	}

}
