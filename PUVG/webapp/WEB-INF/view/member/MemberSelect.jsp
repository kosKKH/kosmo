<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "main.puvg.member.vo.MemberVO" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>내 정보 보기</title>
		<link href="css/DefaultSetting.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div>
			<jsp:include page ="../sidebar/LeftSidebar.jsp" flush ="true"/>
		</div>
		<%
			List<MemberVO> list = (List<MemberVO>)request.getAttribute("selectmem");
			MemberVO mvo = list.get(0);
		%>
		<div class="main_container">
			<div id="member_photo">
				사진 들어갈 공간<%= mvo.getVimg() %>
			</div>
			<div class="member_info">
				<%= mvo.getVname() %><br>
				<%= mvo.getVnum() %><br>
			</div>
			<div class="member_info">
				<%= mvo.getVemail() %>@<%= mvo.getVemail2() %><br>
			</div>
			<div class="member_info">
				<%= mvo.getVaddr() %><br>
				<%= mvo.getVaddr2() %><br>
			</div>
			<div class="member_info">
				<%= mvo.getVph() %><br>
			</div>
			<div class="member_info">
				<%= mvo.getVdept() %><br>
				<%= mvo.getVrank() %><br>
			</div>
			<div class="member_info">
				<%= mvo.getVbirth() %><br>
			</div>
			<div class="member_info">
				<%= mvo.getVhiredate() %><br>
			</div>
			<div class="member_info">
				<%= mvo.getVdeleteyn() %><br>
			</div>
		
		</div>
	</body>
</html>