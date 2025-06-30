<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis실습</title>
<style>
div#emp-container{text-align:center;}
table.tbl-emp{
	margin:0 auto;
	border:1px solid; 
	border-collapse:collapse;
}
table.tbl-emp th, table.tbl-emp td{
	border:1px solid;
	padding:5px;
	background:lightseagreen;
}
div#search-container{
	padding:15px 0;
}
input#btn-search { width: 350px; background: lightslategray; color: white; box-shadow: 0px 3px 15px grey; }
table#tbl-search { margin:0 auto; }
table#tbl-search th,table#tbl-search td {padding:5px 15px;}
table#tbl-search td {text-align:left;}
</style>
</head>
<body>
<div id="emp-container">
	<h2>사원정보 </h2>
	
	<div id="search-container">
		<form name="empSearchFrm" >
			<h3>검색</h3>
			<input type="button" value="초기화" />
			<table id="tbl-search">
				<!-- 직급조회 -->
				<tr>
					<th>직급</th>
					<td>
						<c:forEach var="job" items="${jobList}">
							<input type="checkbox" name="jobCode" 
							id="${job['JOB_CODE']}" value="${job['JOB_CODE']}"/>
							<label for="${job['JOB_CODE']}">${job['JOB_NAME']}</label>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="검색" />
					</th>
				</tr>
			</table>
		</form>
	</div>
	
	
	<table class="tbl-emp">
		<tr>
			<th></th><!-- 1부터 넘버링 처리 -->
			<th>사번</th>
			<th>사원명</th>
			<th>주민번호</th><!--뒷6자리는 ******처리-->
			<th>성별</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서명</th>
			<th>직급명</th>
			<th>급여레벨</th>
			<th>급여</th><!--원화기호, 세자리마다 콤마표시-->
			<th>보너스율</th><!--percent로 표시-->
			<th>매니져 사번</th>
			<th>입사일</th><!--날짜형식 yyyy/MM/dd-->
			<th>퇴사여부</th>
		</tr>
		<c:if test="${empty list}">
		<tr>
			<th colspan="14" style="text-align:center">
				조회된 데이터가 없습니다
			</th>
		</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="emp" items="${list}" varStatus="vs" >			
				<tr>
					<td>${vs.count}</td>
					<td>${emp['EMP_ID']}</td>
					<td>${emp['EMP_NAME']}</td>
					<td>${emp['EMP_NO']}</td>
					<td>${emp['GENDER']}</td>
					<td>${emp['EMAIL']}</td>
					<td>${emp['PHONE']}</td>					
					<td>${emp['DEPT_CODE']}</td>
					<td>${emp['JOB_CODE']}</td>
					<td>${emp['SAL_LEVEL']}</td>
					<td><fmt:formatNumber value="${emp['SALARY']}" type="currency"/></td>
					<td><fmt:formatNumber value="${emp['BONUS']}" type="percent"/> </td>
					<td>${emp['MANAGER_ID']}</td>
					<td><fmt:formatDate value="${emp['HIRE_DATE']}" pattern="yyyy/MM/dd"/></td>
					<td>${emp['QUIT_YN']}</td>
				</tr>				
			</c:forEach>
		</c:if>
	</table>
</div>

</body>
</html>
