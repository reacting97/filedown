package req;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import handler.member.JoinHandler;
import handler.member.LoginHandler;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do") // �������� ��û�� ������ ��� ��û�� ����� �´�.
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// commands.properties ������ url�� ��ɾ �о ������ map
	private Map<String, Handler> map = new HashMap<>();

	// ���� ������ �� �ѹ� ����Ǵ� �޼���.
	@Override
	public void init() throws ServletException {
		Properties prop = new Properties();

		// �Ķ� ��θ� ������ ����ϴ� ���� ��η� ��ȯ
		String path = this.getServletContext().getRealPath("/WEB-INF/commands.properties");
		try {
			// commands.properties ������ Ű, ���� �ε��ؼ� prop�� ����
			prop.load(new FileReader(path));
			Iterator iter = prop.keySet().iterator();
			while (iter.hasNext()) {
				String url = (String) iter.next();// member/join.do
				String className = prop.getProperty(url);// handler.member.JoinHandler
				System.out.println(url + " / " + className);

				try {
					// Class Ŭ������ ���� ���� ����. Ŭ�����̸�, �ɹ������̸�/Ÿ�� �޼��� �̸�/������Ÿ��
					// ������ Ŭ���� ������ ���� Class ��ü ��ȯ
					Class<?> handlerClass = Class.forName(className);
					// ������ Ŭ������ ��ü�� ������ ������ ��ȯ
					Constructor<?> cons = handlerClass.getConstructor(null);
					// handler ��ü ����
					Handler handler = (Handler) cons.newInstance();
					// ������ handler ��ü�� url�� ���� map�� ����

					// �� ������ ���� ���ٰ� ���� => Handler handler = new JoinHandler();
					map.put(url, handler);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��û�� ó���� �� ���������� �̵�
		String url = request.getServletPath();// ��û url��ȯ. join.do
		String view = null;
		Handler handler = map.get(url);

		if (handler != null) {
			view = handler.process(request, response);
			if (view != null) {
				if (view.startsWith("redirect")) {
					String[] path = view.split(":");
					response.sendRedirect(request.getContextPath() + path[1]);
				} else if (view.startsWith("responsebody")) {
					String[] path = view.split("#");
					response.getWriter().append(path[1]);
				} else {
					RequestDispatcher dis = request.getRequestDispatcher(view);
					dis.forward(request, response);
				}
			}
		} else {
			response.getWriter().append("404 not found url");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
