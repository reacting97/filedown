package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;
import member.MemberVo;

/**
 * Servlet implementation class MyInfo
 */
@WebServlet("/member/myinfo")
public class MyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		MemberService service = new MemberService();
		MemberVo m = service.getMember(id);
		//검색한 결과를 request에 담는다. setAttribute(이름, 값);
		request.setAttribute("m", m);
		RequestDispatcher dis = request.getRequestDispatcher("/member/myinfo.jsp");//같은 서버내에서 이동
		//forward():포워드 방식으로 이동. 서버내에서 request,response 객체를 가지고 페이지 이동
		//redirect(): 서버에서 클라이언트에게 다시 페이지 요청하도록 함 
		dis.forward(request, response);//검색한 결과를 request에 담음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		MemberService service = new MemberService();
		MemberVo vo = new MemberVo(id,pwd,name,null);
		service.editMyInfo(vo);
		//get 방식 요청 servlet MyInfo로 감
		response.sendRedirect(request.getContextPath()+"/member/myinfo?id=" +id);
	}

}
