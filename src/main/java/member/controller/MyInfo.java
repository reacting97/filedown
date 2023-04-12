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
		//�˻��� ����� request�� ��´�. setAttribute(�̸�, ��);
		request.setAttribute("m", m);
		RequestDispatcher dis = request.getRequestDispatcher("/member/myinfo.jsp");//���� ���������� �̵�
		//forward():������ ������� �̵�. ���������� request,response ��ü�� ������ ������ �̵�
		//redirect(): �������� Ŭ���̾�Ʈ���� �ٽ� ������ ��û�ϵ��� �� 
		dis.forward(request, response);//�˻��� ����� request�� ����
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
		//get ��� ��û servlet MyInfo�� ��
		response.sendRedirect(request.getContextPath()+"/member/myinfo?id=" +id);
	}

}
