<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
</head>
<body>
	<h3>정보 삭제</h3>
	<!-- 조회한 값을 토대로 정보 수정하도록 -->
	<form action="memberSearch.do" method="post">
		아이디 : <input type="text" name="id">
		<input type="hidden" name="job" value="delete">	
			<!-- memberSearch.jsp 에도 hidden 만들고 여기도 만드는데 다른점은 value 의 값이 다름. 이걸 토대로 MemberSerachController 에서 반환 조건문 만듬 -->
		<input type="submit" value="조회">
	</form><hr>
	
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if(member != null) {
			// 조회 결과 반영
			%>
				<p>ID : <%=member.getId() %></p>
				<p>Name : <%=member.getName() %></p>
				<p>Mail : <%=member.getMail() %></p>
				<form action="memberDelete.do" method="post">
					<input type="hidden" name="id" value="<%=member.getId()%>">
					<input type="submit" value="삭제">
				</form>			
			<%
		} else {
			%>
			<h3>조회 결과 없음</h3>
			<%
		}%><br>
		<a href="index.jsp">메인 화면</a>
		<%
	%>
</body>
</html>