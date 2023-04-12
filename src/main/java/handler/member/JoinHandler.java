package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class JoinHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		//��û ó���� ����� req, res�� �Ķ����� �ް�, ��������� ��θ� ���ϰ����� ��ȯ
		// TODO Auto-generated method stub
		String view = "";
		if(request.getMethod().equals("GET")) {
			request.setAttribute("view", "/member/join.jsp");
			view = "/index.jsp";
		} else {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberService service = new MemberService();
			service.join(new MemberVo(id,pwd,name,email));
			
			view = "redirect:/index.jsp";
		}
		return view;
	}

}
