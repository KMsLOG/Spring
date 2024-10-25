<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 등록</title>
</head>
<body>
	<h1>SSAFY 사용자 등록</h1>
	<form action="regist" method="POST">
        아이디: <input type="text" name="id"><br>
        비밀번호: <input type="password" name="password"><br> 
        이름: <input type="text" name="name"><br> 
        이메일: <input type="email" name="email"><br> 
        나이: <input type="number" name="age"><br> 
        <input type="submit" value="등록">
    </form>
</body>
</html>
