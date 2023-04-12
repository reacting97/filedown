package handler.filedown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import filedown.FileDownService;
import filedown.FileDownVo;
import handler.Handler;

public class DownHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		FileDownService service = new FileDownService();
		int num = Integer.parseInt(request.getParameter("num"));
		FileDownVo vo = service.getById(num);
		
		if(request.getMethod().equals("GET")) {
			request.setAttribute("vo", vo);
			request.setAttribute("view", "/filedown/detail.jsp");
		}else {
			String fname = vo.getFname();
	        String path = FileDownService.downDir + fname;// �ٿ�ε��� ���� ��ü ���

	        //���Ͽ� ���� ����. ����ũ��, �б�, ����, ���� ����, �����ϴ��� ����....
	        File file = new File(path);
	       
	        //�ٿ�ε� ������ ������ ���� ��Ʈ�� ����
	        
			try {
				FileInputStream in = new FileInputStream(path);
				//���ϸ� ���ڵ�, �ѱ� ���ϸ� ������ �ʰ� ���ڵ�ó��
		        fname = new String(fname.getBytes("euc-kr"), "8859_1");

		        //�ٿ�ε� ������ ������ ���� response ����
		        //setContentType(): ������ ���Ӽ���. ������ ����.
		        //octet-stream: ���̳ʸ� ���� �� ����
		        response.setContentType("application/octet-stream");
		        //��� ����. ��Ŷ�� �߿� ������ ����. ÷������ ���� ����
		        response.setHeader("Content-Disposition", "attachment; filename=" + fname);

		        //�ٿ�ε� ���� ������ response�� ����� ��� ��Ʈ�� ȹ��
		        //os Ŭ���̾�Ʈ�� ������ ���佺Ʈ��
		        OutputStream os = response.getOutputStream();

		        int length;
		        //�ٿ�ε� ���Ͽ��� ���� ������ ���� byte�迭�� ���� ũ��� �����ϰ� ����
		        int fsize = (int) file.length();
		        byte[] b = new byte[fsize];
		        //byte[] b = new byte[(int) file.length()];

		        //���Ͽ��� ���� ������ response�� ���
		        while ((length = in.read(b)) > 0) {
		            os.write(b, 0, length);
		        }
		       
		        //�������
		        //��� ���۸� ������ ����� ������
		        os.flush();

		        //��Ʈ�� �ݱ�
		        os.close();
		        in.close();
		        service.upCnt(num);
		        view = null;
		        //view = "redirect:/filedown/detail.do?num="+num;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
		}
		return view;
	}

}
