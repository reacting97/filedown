<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	//request.method: 전송방식 값을 갖는 속성(GET, POST)
	if('${pageContext.request.method}' == 'GET'){
	ff.id.value = opener.document.f.id.value;//opener 회원가입창
	}else{
		let html="";
		if('${flag}' == 'true'){
			html = "사용가능한 아이디";
			let val = '${id}';
			ff.id.value = val;
			html += "<input type='button' value='아이디사용' onclick='a(\""+val+"\")'>";
			//"\"asdf\"" escape문
		}else{
			html = "중복된 아이디";
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
<h3>중복체크</h3>
<form action="${pageContext.request.contextPath }/member/idcheck" method="post" name="ff">
id:<input type="text" name="id">
<input type="submit" value="체크">
</form>
<div id='res'>

</div>
</body>
</html>