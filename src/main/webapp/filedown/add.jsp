<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/filedown/add.do" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }"readonly></td></tr>
			<tr><th>title</th><td><input type="text" name="title"></td></tr>
			<tr><th>content</th><td><textarea rows="20" cols="30" name="content"></textarea></td></tr>
			<tr><th>file_name</th><td><input type="file" name="file"></td></tr>
			<tr><th>업로드</th><td><input type="submit" value="저장"></td></tr>
		</table>
</form>
</body>
</html>