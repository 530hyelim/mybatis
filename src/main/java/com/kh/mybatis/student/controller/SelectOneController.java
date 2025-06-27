package com.kh.mybatis.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.model.service.StudentServiceImpl;
import com.kh.mybatis.student.model.vo.Student;

@WebServlet("/student/selectOne")
public class SelectOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("no");
		int no = 0;
		if (param != null) {
			no = Integer.parseInt(param);
		}
		// 비즈니스 로직
		StudentService service = new StudentServiceImpl();
		// 1. 전체학생수 조회
		int total = service.selectStudentCount();
		// 2. no와 일치하는 학생 조회 (단 no가 0이 아닌 경우)
		if (no > 0) {
			Student student = service.selectOneStudent(no);
			request.setAttribute("student", student);
		}
		request.setAttribute("total", total);
		request.getRequestDispatcher("/student/selectOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
