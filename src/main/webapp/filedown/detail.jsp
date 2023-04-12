<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

function a(){
	const xhttp = new XMLHttpRequest();
	xhttp.onload=function(){
		let val = xhttp.responseText;
		let obj = JSON.parse(val);
		let td = document.getElementById("cnt");
		td.innerHTML = obj.cnt;
	}
	xhttp.open("GET", "${pageContext.request.contextPath }/filedown/editcnt.do?num=${vo.num}");
	xhttp.send();
}
</script>
</head>
<body>
<h3>자료 내용</h3>
<a href="${pageContext.request.contextPath }/filedown/list.jsp"></a><br/>
<table border="1">
<tr><th>제목</th><td>${vo.title }</td></tr>
<tr><th>작성자</th><td>${vo.writer }</td></tr>
<tr><th>작성일</th><td>${vo.date }</td></tr>
<tr><th>파일명</th><td>${vo.fname }
<form action="${pageContext.request.contextPath }/filedown/detail.do" method="post">
<input type="hidden" name="num" value="${vo.num }">
<input type="submit" value="download">
</form></td></tr>
<tr><th>다운수</th><td id="cnt">${vo.cnt }</td></tr>
<tr><th>내용</th><td>${vo.content }</td></tr>
</table>
</body>
</html>