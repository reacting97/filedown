<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>����������</h3>

<form action="${pageContext.request.contextPath }/member/edit.do" method="post">
		<table border="1">
			<tr><th>ID</th><td><input type="text" name="id" value="${m.id }" readonly></td></tr>
			<tr><th>PWD</th><td><input type="text" name="pwd" value="${m.pwd }"></td></tr>
			<tr><th>NAME</th><td><input type="text" name="name" value="${m.name }"></td></tr>
			<tr><th>EMAIL</th><td><input type="text" name="email" value="${m.email }" readonly></td></tr>
			<tr><th>����</th>
			<td><input type="submit" value="�����Ϸ�" onclick="javascript:alert('�����Ǿ����ϴ�')">
			<input type="button" value="���" onclick="javascript:location.href='${pageContext.request.contextPath }/index.jsp'"></td></tr>
		</table>
	</form>

</body>
</html>