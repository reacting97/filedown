<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function idcheck(){
	//�񵿱� ��û ��ü ����
	const xhttp = new XMLHttpRequest();
	
	//�񵿱� ��û ������ ������ �ڵ� ����� �ڵ鷯 ���
	xhttp.onload = function(){
		let val = xhttp.responseText;
		alert(val);
		let html = '<h4 style="color:'
		let obj = JSON.parse(val);
		if(obj.flag){
			html += 'blue">��밡���� ���̵�</h4>';
		}
		else{
			html += 'red">��� �Ұ����� ���̵�</h4>';
		}
		let res = document.getElementById("res");
		res.innerHTML = html;//responseText: �����κ��� ���� ���䰪
	}
	
	//��û ���۹��, ���������� url ����. get����� ��� url�ڿ� �Ķ� ����
	let param = "?id="+ f.id.value;
	xhttp.open("GET", "${pageContext.request.contextPath}/member/idcheck.do"+param);
	xhttp.send();
}
</script>
</head>
<body>
	<h3>ȸ������</h3>
	
	<form action="${pageContext.request.contextPath }/member/join.do" method="post" name="f">
		<table border="1">
			<tr><th>ID</th>
			<td>
				<input type="text" name="id">
				<input type="button" value="id�ߺ�üũ" onclick="idcheck()">
				<span id="res"></span>
				</td></tr>
			<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
			<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
			<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
			<tr><th>����</th><td><input type="submit" value="����"></td></tr>
		</table>
	</form>
</body>
</html>