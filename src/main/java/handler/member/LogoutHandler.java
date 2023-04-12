package handler.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;
//url: /member/logout
public class LogoutHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);//�� ���Ǹ��� ���� ���� �����Ͷ�
		session.invalidate();//���� ��ȿȭ
			
		
		return "/index.jsp";
	}
	

}
