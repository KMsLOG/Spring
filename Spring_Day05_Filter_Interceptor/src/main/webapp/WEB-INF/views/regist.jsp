<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 화면</title>
</head>
<body>
	<h1>등록하는 화면</h1>
		<!-- 로그인 O (로그아웃) -->
	<c:if test="${not empty loginUser }">
		<span>${loginUser }님 반갑습니다.</span>
		<a href = "/logout">로그아웃</a>
	</c:if>
</body>
</html>