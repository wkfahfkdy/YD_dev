<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch.jsp</title>
</head>
<body>
	<h3>회원정보 검색</h3><hr>
	<form action="memberSearch.do">
		아이디 : <input type="text" name="id">
		<input type="hidden" name="job" value="search">
		<input type="submit" value="검색">
	</form><br>
	<a href="index.jsp">메인 화면</a>
</body>
</html>