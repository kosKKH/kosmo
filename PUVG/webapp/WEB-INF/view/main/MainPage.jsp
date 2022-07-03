<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PUVG GroupWare</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<style type ="text/css">
		#main_view {
			width : 100%;
			height : 900px;
		}
		
		.main_small_view {
			width : 750px;
			height : 410px;
			background-color : green;
			float : left;
			padding : 20px;
		}
		</style>
	</head>
	<body>
		
		<div>
			<jsp:include page ="../sidebar/LeftSidebar.jsp" flush ="true"/>
		</div>
		<div id="main_view">
			<div class="main_small_view">
			회원정보
			</div>
			<div class="main_small_view">
			일정관리
			</div>
			<div class="main_small_view">
			게시판
			</div>
			<div class="main_small_view">
			전자결재
			</div>
		</div>
	</body>
</html>