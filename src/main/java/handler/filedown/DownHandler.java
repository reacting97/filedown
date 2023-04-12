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
	        String path = FileDownService.downDir + fname;// 다운로드할 파일 전체 경로

	        //파일에 대한 정보. 파일크기, 읽기, 쓰기, 실행 가능, 존재하는지 유무....
	        File file = new File(path);
	       
	        //다운로드 파일의 내용을 읽을 스트림 생성
	        
			try {
				FileInputStream in = new FileInputStream(path);
				//파일명 인코딩, 한글 파일명 깨지지 않게 인코딩처리
		        fname = new String(fname.getBytes("euc-kr"), "8859_1");

		        //다운로드 응답을 보내기 위한 response 설정
		        //setContentType(): 파일의 마임설정. 파일의 종류.
		        //octet-stream: 바이너리 파일 한 종류
		        response.setContentType("application/octet-stream");
		        //헤더 설정. 패킷의 중요 정보를 설정. 첨부파일 전송 설정
		        response.setHeader("Content-Disposition", "attachment; filename=" + fname);

		        //다운로드 파일 내용을 response에 출력할 출력 스트림 획득
		        //os 클라이언트에 보내는 응답스트림
		        OutputStream os = response.getOutputStream();

		        int length;
		        //다운로드 파일에서 읽은 내용을 담을 byte배열을 파일 크기와 동일하게 생성
		        int fsize = (int) file.length();
		        byte[] b = new byte[fsize];
		        //byte[] b = new byte[(int) file.length()];

		        //파일에서 읽은 내용을 response에 출력
		        while ((length = in.read(b)) > 0) {
		            os.write(b, 0, length);
		        }
		       
		        //강제출력
		        //출력 버퍼를 강제로 비워서 내보냄
		        os.flush();

		        //스트림 닫기
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
