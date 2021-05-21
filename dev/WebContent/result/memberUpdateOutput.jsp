<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberUpdateOutput.jsp</title>
</head>
<body>
	<h3>정보 수정 완료</h3><hr>
	<p>${member.id } 의 정보</p>
	<p>Name : ${member.name }</p>
	<p>Mail : ${member.mail }</p>
	<a href="index.jsp">메인 화면</a>
</body>
</html>