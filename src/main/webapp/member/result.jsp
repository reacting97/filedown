<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>${sessionScope.loginId }님 로그인 성공</h3>
<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
<a href="${pageContext.request.contextPath }/member/myinfo?id=${sessionScope.loginId}">내정보확인</a>
<a href="${pageContext.request.contextPath }/member/del?id=${sessionScope.loginId}">탈퇴</a>
</body>
</html>