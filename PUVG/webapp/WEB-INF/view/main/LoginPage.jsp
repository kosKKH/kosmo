<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PUVG GroupWare</title>
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<link href="css/LoginPage.css" rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$(document).on("click","#login_btn",function(){
				var id = $("#mem_id").val();
				var pw = $("#mem_pw").val();
				
				
				$.ajax({
					url : "logincheck.puvg",
					type : "POST",
					data : {vnum : id, vpw : pw},
					success : whensuc,
					error : whenerr
				});
				
				function whensuc(resdata) {
					if(resdata == "success") {
						location.href="mainpage.puvg";
					} else {
						alert("아이디 혹은 비밀번호가 잘못 되었습니다.")
					}
				}
				
				function whenerr(e) {
					alert("에러 발생 : " + e.responseText);
				}
			})
		});
		
		</script>
	</head>
	<body>
		<div id="main_div">
			<div id="photo_div">
			사진이 들어갈 공간입니다.
			</div>
			<div id="login_div">
				<div id="login_form">
					<input type="text" id="mem_id" name="mem_id"><br>
					<input type="password" id="mem_pw" name="mem_pw"><br>
					<input type="button" id="login_btn" name="login_btn" value="login"><br>
				</div>
			</div>
		</div>
	</body>
</html>