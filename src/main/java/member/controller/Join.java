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
 * Servlet implementation class Join
 */
@WebServlet("/member/join")//이 페이지의 웹에서 접근 경로
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Join() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //get요청시 회원가입 폼을 준다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 요청받음
		//2. 서비스 메서드 요청을 처리
		//3. 처리 결과 페이지로 이동
		//RequestDispatcher:request,response객체를 가지고 페이지 이동 생성자 파람으로 이동할 뷰 페이지 경로
		RequestDispatcher dis = request.getRequestDispatcher("/member/join.jsp");//같은 서버내에서 이동
		//forward():포워드 방식으로 이동. 서버내에서 request,response 객체를 가지고 페이지 이동
		//redirect(): 서버에서 클라이언트에게 다시 페이지 요청하도록 함 
		dis.forward(request, response);//검색한 결과를 request에 담음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//사용자가 입력한 데이터로 회원가입을 완료
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberService service = new MemberService();
		service.join(new MemberVo(id,pwd,name,email));
		
		//클라이언트에 페이지를 새로 요청하도록 시킴
		//request가 새 객체이므로 이전에 저장한 데이터 모두 없어짐
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
