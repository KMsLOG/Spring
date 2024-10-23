<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home</title>
</head>
<body>
	<h2>${msg }</h2>
	
	<form action="home" method="POST">
		<button>Home(POST)</button>
	</form>
	<form action="home" method="GET">
		<button>Home(GET)</button>
	</form>
</body>
</html>