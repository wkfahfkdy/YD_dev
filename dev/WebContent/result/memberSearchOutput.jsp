<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberSearchOutput.jsp</title>
</head>
<body>
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if(member != null){
			%>
			<h3>회원검색 결과</h3><hr>
			<p>${member.id } 의 정보</p>
			<p>이름 : ${member.name }</p>
			<p>메일 : ${member.mail }</p><br>
			<a href="index.jsp">메인 화면</a>
			<%
		} else {
			%>
			<h3>조회 결과 없음</h3>
			<a href="memberSearch.jsp">돌아가기</a>
			<%
		}
	%>

</body>
</html>