<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInsert.jsp</title>
</head>
<body>
	<h3>회원가입 페이지</h3><hr>
	<form action="memberInsert.do" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		이름 : <input type="text" name="name"><br>
		메일 : <input type="email" name="mail"><br>
		<input type="submit" value="등록">
	</form><br>
	<a href="index.jsp">메인 화면</a>
</body>
</html>