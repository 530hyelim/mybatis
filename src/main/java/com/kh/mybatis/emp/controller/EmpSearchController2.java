package com.kh.mybatis.emp.controller;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet("/emp/search2")
public class EmpSearchController2 extends HttpServlet{

	private EmpService empService = new EmpServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
        String searchKeyword = request.getParameter("searchKeyword");
        String gender = request.getParameter("gender");
        int salary = 0;
        try {
            salary = Integer.parseInt(request.getParameter("salary"));
        } catch(NumberFormatException e) {}
        String salaryCompare = request.getParameter("salaryCompare");
        String hire_date = request.getParameter("hire_date");
        String hiredateCompare = request.getParameter("hiredateCompare");
		
        Map<String, Object> param = new HashMap<>();
        param.put("searchType", searchType);
        param.put("searchKeyword", searchKeyword);
        param.put("gender", gender);
        param.put("salary", salary);
        param.put("salaryCompare", salaryCompare);
        param.put("hire_date", hire_date);
        param.put("hiredateCompare", hiredateCompare);
        
        List<Map<String, Object>> list = empService.search2(param);
        request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/search2.jsp").forward(request, response);
	}
}
