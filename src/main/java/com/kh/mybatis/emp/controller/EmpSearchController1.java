package com.kh.mybatis.emp.controller;

import java.io.IOException;
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

@WebServlet("/emp/search1")
public class EmpSearchController1 extends HttpServlet {

	private EmpService empService = new EmpServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		
		if (searchKeyword == null) {
			List<Map<String, Object>> list = empService.selectAllEmp();
			request.setAttribute("list", list);
		} else {
			List<Map<String, Object>> list = empService.search1(param);
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("/emp/search1.jsp").forward(request, response);
	}
}
