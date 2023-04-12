package handler.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class LoginHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "/index.jsp";
		String msg = "로그인 실패";
		if(request.getMethod().equals("GET")) {
			request.setAttribute("view", "/member/login.jsp");
			view = "/index.jsp";
		} else {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			MemberService service = new MemberService();
			MemberVo vo = service.getMember(id);
			String path = "/member/login.jsp";
			if(vo!=null && pwd.equals(vo.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginId", id);
				path = "/index.jsp";
			}else {
				request.setAttribute("msg", "�α��ν���");
			}
			
			view = path;
		}
		return view;
	}

}
