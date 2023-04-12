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
@WebServlet("/member/join")//�� �������� ������ ���� ���
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
    //get��û�� ȸ������ ���� �ش�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. ��û����
		//2. ���� �޼��� ��û�� ó��
		//3. ó�� ��� �������� �̵�
		//RequestDispatcher:request,response��ü�� ������ ������ �̵� ������ �Ķ����� �̵��� �� ������ ���
		RequestDispatcher dis = request.getRequestDispatcher("/member/join.jsp");//���� ���������� �̵�
		//forward():������ ������� �̵�. ���������� request,response ��ü�� ������ ������ �̵�
		//redirect(): �������� Ŭ���̾�Ʈ���� �ٽ� ������ ��û�ϵ��� �� 
		dis.forward(request, response);//�˻��� ����� request�� ����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//����ڰ� �Է��� �����ͷ� ȸ�������� �Ϸ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberService service = new MemberService();
		service.join(new MemberVo(id,pwd,name,email));
		
		//Ŭ���̾�Ʈ�� �������� ���� ��û�ϵ��� ��Ŵ
		//request�� �� ��ü�̹Ƿ� ������ ������ ������ ��� ������
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
