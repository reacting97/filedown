package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
//url: /member/out
public class OutHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("loginId");
		MemberService service = new MemberService();
		service.delMember(id);
		
		return "redirect:/member/logout.do";
	}

}
