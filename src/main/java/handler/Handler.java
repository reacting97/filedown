package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����û ó�� Ŭ������ �θ�
public interface Handler {
	String process(HttpServletRequest request, HttpServletResponse response);
}
