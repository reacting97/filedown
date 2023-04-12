package handler.filedown;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import filedown.FileDownService;
import filedown.FileDownVo;
import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if(request.getMethod().equals("GET")) {
			request.setAttribute("view", "/filedown/add.jsp");
		} else {
			int size = 100 * 1024 * 1024;
			MultipartRequest multipart;
			try {
				multipart = new MultipartRequest(request, FileDownService.downDir, size, "euc-kr", new DefaultFileRenamePolicy());
				String writer = multipart.getParameter("writer");
				String title = multipart.getParameter("title");
				String content = multipart.getParameter("content");
				File f = multipart.getFile("file");
				String fname = f.getName();
				
				
				FileDownService service = new FileDownService();
				service.addFile(new FileDownVo(0,writer,null,title,content,fname,0));
				
				view = "redirect:/filedown/list.do";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return view;
	}

}
