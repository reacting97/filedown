<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>LOGIN</h3>
${msg }<br/>
<form action="${pageContext.request.contextPath }/member/login.do" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id"></td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>login</th>
<td><input type="submit" value="�α���"><a href="${pageContext.request.contextPath }/member/join">ȸ������</a></td></tr>

</table>
</form>
</body>
</html>