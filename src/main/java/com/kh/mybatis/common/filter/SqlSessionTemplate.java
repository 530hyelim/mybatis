package com.kh.mybatis.common.filter;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	/*
	 * 어플리케이션 시작 시 SqlSessionFactory를 1회만 생성하여 재사용하도록 코드를 작성
	 */
	private static SqlSessionFactory sqlSessionFactory;
	
	// 스태틱 초기화 블럭 : 현재 클래스가 로딩되는 시점에서 단 1번 실행
	static {
		String resource = "/mybatis-config.xml";
		System.out.println("팩토리 생성");
		// 자바파일들의 최상위 경로 : 웹앱 아래 classes 폴더 (/mybatis/classes/...)
		// src/main/java 안에 resources 폴더 만들어도 되는데 보통 별도로 관리함
		// src 소스폴더(build > use as source folder)만들면 자동으로 (classes 폴더로)빌드됨
		try(InputStream input = Resources.getResourceAsStream(resource)){
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// sqlSession(마이바티스 핵심 객체. crud, 트랜잭션 관리 역할)반환 메서드
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession(false); // 수동커밋설정
	}
}
