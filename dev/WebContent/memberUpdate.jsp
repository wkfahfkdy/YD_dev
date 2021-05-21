<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate.jsp</title>
</head>
<body>
	<h3>정보 수정</h3><hr>
	<!-- 조회한 값을 토대로 정보 수정하도록 -->
	<form action="memberSearch.do" method="post">
		아이디 : <input type="text" name="id">
		<input type="hidden" name="job" value="update">	
			<!-- memberSearch.jsp 에도 hidden 만들고 여기도 만드는데 다른점은 value 의 값이 다름. 이걸 토대로 MemberSerachController 에서 반환 조건문 만듬 -->
		<input type="submit" value="조회">
	</form><hr>
	
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if(member != null) {
			// 입력 화면
			%>
			<form action="memberUpdate.do" method="post">
			아이디 : <input type="text" name="id" value="<%=member.getId() %>" readonly><br> 
				<!-- value를 ${memeber.id } 하면 될 줄 알았는데 아닌가봄 // readonly 를 써야함 disabled 는 값 전달 못함 -->
			비밀번호 : <input type="password" name="passwd" value="<%=member.getPasswd() %>"><br>
			이름 : <input type="text" name="name" value="<%=member.getName() %>"><br>
			메일 : <input type="email" name="mail" value="<%=member.getMail() %>"><br>
			<input type="submit" value="수정">
			</form>
			<%
		} else {
			// 조회된 결과 X
			// out.print("조회 결과 없음");
			%>
			<h3>조회 결과 없음</h3>
			<%
		}%><br>
		<a href="index.jsp">메인 화면</a>
		<%
	%>
</body>
</html>