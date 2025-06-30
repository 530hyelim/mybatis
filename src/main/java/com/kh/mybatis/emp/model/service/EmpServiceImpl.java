package com.kh.mybatis.emp.model.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.filter.SqlSessionTemplate;
import com.kh.mybatis.emp.model.dao.EmpDao;
import com.kh.mybatis.emp.model.dao.EmpDaoImpl;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao = new EmpDaoImpl();

	@Override
	public List<Map<String, Object>> selectAllEmp() {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, Object>> list = empDao.selectAllEmp(session);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> search1(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, Object>> list = empDao.search1(session, param);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> search2(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, Object>> list = empDao.search2(session, param);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, String>> selectJobList() {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, String>> jobList = empDao.selectJobList(session);
		session.close();
		return jobList;
	}

	@Override
	public List<Map<String, Object>> search3(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, Object>> list = empDao.search3(session, param);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, String>> selectDeptList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectOneEmp(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmp(Map<String, String> param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	

}
