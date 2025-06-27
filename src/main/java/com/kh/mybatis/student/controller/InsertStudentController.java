package com.kh.mybatis.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.model.service.StudentServiceImpl;
import com.kh.mybatis.student.model.vo.Student;

@WebServlet("/student/insertStudent")
public class InsertStudentController extends HttpServlet{
	
	private StudentService service = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/student/insertStudent.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 학생정보 insert (핵심 로직)
		
		// 1. 사용자가 전송한 데이터 가공처리 (wrapping)
		// argument resolver (spring framework)
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		Student s = new Student();
		s.setName(name);
		s.setTel(tel);
		
		// 2. service 메서드 호출
		int result = service.insertStudent(s); // 1 or 0
		
		// 3. 처리결과에 따른 응답처리
		if (result == 1) {
			// 데이터 삽입 성공
			// 서비스 처리결과 메세지 추가
			req.getSession().setAttribute("msg", "학생 등록 성공~~~~~^^..");
			// 리다이렉트 (request 초기화)
			resp.sendRedirect(req.getContextPath()+"/student/insertStudent");
		} else {
			req.getSession().setAttribute("msg", "학생 등록 실패~~~~ㅠㅠㅠㅠ~~");
			resp.sendRedirect(req.getContextPath()+"/student/insertStudent"); // 에러페이지
			// 비동기 연결이였으면 404 500같은 에러코드를 같이 보내줄 수도 있음
		}
	}
}







