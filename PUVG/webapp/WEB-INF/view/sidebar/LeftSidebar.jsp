<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="main.puvg.member.vo.MemberVO"%>  
<%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link href="css/LeftSidebar.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function(){
			$("#menusmall1").hide();
			$("#menusmall2").hide();
			$("#menusmall3").hide();
			
			$("#menuBig1").click(function(){
				$("#menusmall1").slideDown();
				$("#menusmall2").slideUp();
				$("#menusmall3").slideUp();
			});
			
			$("#menuBig2").click(function(){
				$("#menusmall2").slideDown();
				$("#menusmall1").slideUp();
				$("#menusmall3").slideUp();
			});
			
			$("#menuBig3").click(function(){
				$("#menusmall3").slideDown();
				$("#menusmall1").slideUp();
				$("#menusmall2").slideUp();
			});
		});
	</script>

	</head>
	<body>
		<div id="menu">
			<div class="logo">
			로고 들어갈 자리
			</div>
			<div id="menuBig1" class="menuBig">
				메뉴 1
			</div>
			<div id="menusmall1" class="menuSmall">
				<a href="#">소제목1</a><br>
				<a href="#">소제목2</a><br>
				<a href="#">소제목3</a><br>
			</div>
			<div id="menuBig2" class="menuBig">
				메뉴 2
			</div>
			<div id="menusmall2" class="menuSmall">
				<a href="#">menu1</a><br>
				<a href="#">menu2</a><br>
				<a href="#">menu3</a><br>
			</div>
			<div id="menuBig3" class="menuBig">
				메뉴 3
			</div>
			<div id="menusmall3" class="menuSmall">
				<a href="#">작은 메뉴1</a><br>
				<a href="#">작은 메뉴2</a><br>
				<a href="#">작은 메뉴3</a><br>
			</div>
		</div>
		<div id="top_bar">
		<%
			HttpSession Session = request.getSession(false);
			String VID = (String)Session.getAttribute("VID");
			String VNAME = (String)Session.getAttribute("VNAME");
		%>
			<font size="2"><%= VID %>님 <%= VNAME %> 안녕하세요!</font>
		<%

		%>
			날씨정보, 오늘날짜, XXX님 안녕하세요
		</div>
	</body>
</html>