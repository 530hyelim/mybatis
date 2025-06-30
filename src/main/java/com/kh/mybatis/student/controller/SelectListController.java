package com.kh.mybatis.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentServiceImpl;
import com.kh.mybatis.student.model.vo.Student;

@WebServlet("/student/selectList")
public class SelectListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 업무로직
		// list.jsp 호출 전 학생정보를 request 스코프에 담아 포워딩
		List<Student> list = new StudentServiceImpl().selectStudentList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/student/selectList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
