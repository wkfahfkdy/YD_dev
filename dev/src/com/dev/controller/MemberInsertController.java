package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 신규 회원 등록 기능 -> memberInsertOutput.jsp
		
		// 입력한 parameter 읽어와서
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		// 넣
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setMail(mail);
		member.setName(name);
		member.setPasswd(passwd);
		
		// 서비스 로직 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("result/memberInsertOutput.jsp");
		rd.forward(request, response);
		
	}
	
}
