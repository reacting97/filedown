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
<table border="1">
<tr><th>title</th><th>writer</th><th>다운수</th></tr>
<c:forEach var="vo" items="${list }">
<tr><td><a href="${pageContext.request.contextPath }/filedown/detail.do?num=${vo.num }">${vo.title }</a></td>
<td>${vo.writer }</td><td>${vo.cnt }</td></tr>
</c:forEach>
</table>
</body>
</html>