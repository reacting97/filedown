<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�Խ���</h3>
<table border="1">
<tr><td colspan="5"><h3>�ڷ��</h3></td></tr>
<tr><td><a href="${pageContext.request.contextPath }/member/join.do">ȸ������</a></td>
<td><a href="${pageContext.request.contextPath }/member/login.do">�α���</a></td>
<td><a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId}">������Ȯ��</a></td>
<td><a href="${pageContext.request.contextPath }/member/logout.do">�α׾ƿ�</a></td>
<td><a href="${pageContext.request.contextPath }/member/out.do">Ż��</a></td>
<c:if test="${not empty sessionScope.loginId }">
<tr>
	<td colspan="2"><a href="${pageContext.request.contextPath }/filedown/add.do">�ڷ�ø���</a></td>
	<td colspan="3"><a href="${pageContext.request.contextPath }/filedown/list.do">�ڷ��Ϻ���</a></td>
</tr>
</c:if>
</tr>
</table>
<div id="body">
${msg }
<c:if test="${not empty view }">
<jsp:include page="${view }"/>
</c:if>
</div>
</body>
</html>
