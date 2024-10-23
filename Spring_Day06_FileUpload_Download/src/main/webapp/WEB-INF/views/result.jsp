<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 결과</title>
</head>
<body>
	${fileName }
	<a href="/img/${fileName }">${fileName }</a>
	<img src="/img/${fileName }">
	
	<a href="/download?fileName=${fileName }">다운로드</a>
</body>
</html>