<%@page import="com.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result/memberListOutput.jsp</title>
</head>
<body>
	<h3>회원 리스트</h3><hr>
	<c:choose>
		<c:when test="${empty list }">
			<!-- when = if문. otherwise = else << choose 안에 써야함 -->
			<h3>조회 결과 없음</h3><br>
		</c:when> 
		<c:otherwise>
			<ul>
				<c:forEach items="${list }" var="member"> 
					<li>${member.id } / ${member.name } / ${member.mail }</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<a href="index.jsp">메인 화면</a>
	
	<%-- c: 쓰는 방식으로 할거라 이거 주석 처리. 이거도 잘 나옴
	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
	if(list.size() == 0) {
		%>
		<h3>조회 결과 없음</h3><br>
		<a href="index.jsp">메인 화면</a>
		<%
	} else {
		out.print("<ul>");
		for(MemberVO member : list) {
			out.print("<li>" + member.getId() + " / " + member.getName() + " / " + member.getMail() + "</li>");
		}
		out.print("</ul>");
	}
	%>
	 --%>
</body>
</html>