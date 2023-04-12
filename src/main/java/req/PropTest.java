package req;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PropTest
 */
@WebServlet("/PropTest")
public class PropTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();//���� �� ����. ���α׷��� ����, ���� �� ��Ÿ �����͸� ����
		
		prop.put("key1", "val1");
		prop.put("key2", "val2");
		prop.put("key3", "val3");
		FileWriter fw = new FileWriter("b.properties");
		//properties ��ü�� ������ ���Ͽ� ����
		prop.store(fw, "comments");
		
		Properties prop2 = new Properties();
		FileReader fr = new FileReader("b.properties");
		//���� �����͸� �о properties ��ü�� ����
		prop2.load(fr);
		Iterator iter = prop2.keySet().iterator();
		PrintWriter pw = response.getWriter();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			pw.append(key + " : " + prop2.getProperty(key) + "\n");
			
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
