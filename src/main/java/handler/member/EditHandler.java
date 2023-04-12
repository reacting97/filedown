package handler.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class EditHandler implements Handler {
//url: /member/edit.do
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if(request.getMethod().equals("GET")) {
			HttpSession session = request.getSession(false);
			String id = (String) session.getAttribute("loginId");
			MemberService service = new MemberService();
			MemberVo m = service.getMember(id);
			//검색한 결과를 request에 담는다. setAttribute(이름, 값);
			request.setAttribute("m", m);
			request.setAttribute("view", "/member/edit.jsp");
		} else {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			MemberService service = new MemberService();
			MemberVo vo = new MemberVo(id,pwd,name,null);
			service.editMyInfo(vo);
			
			view="redirect:/member/edit.do?id="+id;
		}
		return view;
	}
	

}
