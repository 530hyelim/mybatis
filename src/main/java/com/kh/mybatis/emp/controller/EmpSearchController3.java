package com.kh.mybatis.emp.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.emp.model.service.EmpService;
import com.kh.mybatis.emp.model.service.EmpServiceImpl;

@WebServlet("/emp/search3")
public class EmpSearchController3 extends HttpServlet {

	protected EmpService empService = new EmpServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 직급정보 조회 후, request에 저장
		List<Map<String, String>> jobList = empService.selectJobList();
		request.setAttribute("jobList", jobList);
		
		// 사용자가 선택한 직급정보 추출
		String[] jobCodeArr = request.getParameterValues("jobCode");
		Map<String, Object> param = new HashMap<>();
		param.put("jobCodeArr", jobCodeArr);
		
		List<Map<String, Object>> list = empService.search3(param);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/search3.jsp").forward(request, response);
	}
}
