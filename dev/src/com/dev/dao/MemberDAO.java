package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dev.vo.MemberVO;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstatnce() {
		return dao;
	}
	
	// 연결처리 Connection 객체
	private void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	// resource 반환
	private void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// DB 처리 기능
	
	// 회원 가입. insert
	public void insertMember(MemberVO member) {
		connect();
		
		String sql = "insert into member_b(id, passwd, name, mail) values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPasswd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getMail());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 한 건 조회. select 
	public MemberVO searchMember(String id) {
		connect();
		
		String sql = "select * from member_b where id = ?";
		
		MemberVO member = null;
		/* 
		 여기서 null 이고 아래서 new 로 만드는 이유
		 update 에서 조회 후 수정을 하는데
		 조회를 했을 때 값이 null이냐 아니냐라는 조건문이 있어서
		 조회를 못했을 시 기본적으로 null 이 나오게하기위해서 여기선 null 로 만들어둠
		 
		 물론 그냥 여기서 new 로 잡아도 방버은 있다.
		 그러면 조건문에 && id.equals("id") 이런거?? 같은 것을 붙혀야 할 것
		*/
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return member;
	}
	public void updateMember(MemberVO member) {
		connect();
		
		String sql = "update member_b set passwd=?, name=?, mail=? where id = ?";
		int r = 0;
		
		try {
			psmt = conn.prepareCall(sql);
			psmt.setString(1, member.getPasswd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getMail());
			psmt.setString(4, member.getId());
			
			r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	public void deleteMember(String id) {
		connect();
		
		String sql = "delete from member_b where id = ?";
		int r = 0;
		
		try {
			psmt = conn.prepareCall(sql);
			psmt.setString(1, id);
			
			r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<MemberVO> listMember() {
		connect();
		
		String sql = "select * from member_b order by 1";
		List<MemberVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
}
