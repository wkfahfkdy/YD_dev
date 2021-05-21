package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  전체 Application의 Controller 등록 관리
  *.do, *.action 을 붙혀서 구조를 통일하는데
  *.do 를 사용할 예정
*/

public class FrontController extends HttpServlet {

	HashMap<String, Controller> list;
	String charset = null;	// web.xml 에서 param 설정했던 것
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");	// 여기서 web.xml 설정값 불러옴
		
		// front page 요청하면 제일 처음 한 번만 실행
		list = new HashMap<>();
		System.out.println("Front init()");
		// list.put("/요청페이지.do", "요청 페이지의 Controller");
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI();	// /dev/insertMember.do
		String contextPath = req.getContextPath();	// /dev
		// /insertMember.do
		String path = uri.substring(contextPath.length());		
		System.out.println(path);	// 위의 과정은 path 정보를 가져오고 싶어서 확인 차. sysout 으로 다 봤었음
		
		Controller sub = list.get(path); // controller
		sub.execute(req, resp);
		
	}
}
