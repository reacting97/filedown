<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	//request.method: ���۹�� ���� ���� �Ӽ�(GET, POST)
	if('${pageContext.request.method}' == 'GET'){
	ff.id.value = opener.document.f.id.value;//opener ȸ������â
	}else{
		let html="";
		if('${flag}' == 'true'){
			html = "��밡���� ���̵�";
			let val = '${id}';
			ff.id.value = val;
			html += "<input type='button' value='���̵���' onclick='a(\""+val+"\")'>";
			//"\"asdf\"" escape��
		}else{
			html = "�ߺ��� ���̵�";
		}
		let div = document.getElementById("res");
		div.innerHTML = html;
	}
	
}

function a(id){
	opener.document.f.id.value = id;
	close();
}
</script>
</head>
<body>
<h3>�ߺ�üũ</h3>
<form action="${pageContext.request.contextPath }/member/idcheck" method="post" name="ff">
id:<input type="text" name="id">
<input type="submit" value="üũ">
</form>
<div id='res'>

</div>
</body>
</html>