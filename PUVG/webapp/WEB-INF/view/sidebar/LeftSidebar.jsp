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
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<script type="text/javascript">
	
		$(document).ready(function(){
			$(".menus").click(function(){
				$(this).children(".submenu").stop().slideDown();
			});
			$(".menus").mouseleave(function(){
				$(this).children(".submenu").stop().slideUp();
			});
		});
		
	</script>
	</head>
	<body>
	<header>
		<div id="tops" class="tops">
		<%
			HttpSession Session = request.getSession(false);
			String VNAME = (String)Session.getAttribute("VNAME");
		%>
			<div id="top_bar_weather">
			
			</div>
			<div id="top_bar_login">
				<font size="2"><%= VNAME %>님 안녕하세요!</font>
			</div>
			<a href="memberSelect.puvg"><font size="2">내 정보</font></a>
			<a href="logout.puvg"><font size="2">로그아웃</font></a>
		</div>
	</header>
		<div id="menu" class="menu">
			<div class="logo" style="align-items: center; display: flex; justify-content: center;">
				<a href="mainpage.puvg" style="text-align:center;"><img Class="img" src="/PUVG/css/icons/logo.png" style="width: 60%; height: 80%; align:center;"/></a>
			</div>
			<label for="expand-menu"><div>&nbsp;&nbsp;&nbsp;&nbsp;메뉴</div></label>
			 <input type="checkbox" id="expand-menu" name="expand-menu">
			 <ul id = "nav-v1">
			   <li class = "menus"><span class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;일정관리</div></span>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		       <li class = "menus"><span class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;웹저장소</div></span>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		        <li class = "menus"><span class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;소통게시판</div></span>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		        <li class = "menus"><span class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;결재문서</div></span>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		        <li class = "menus"><span class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;이메일</div></span>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
			   <li class = "menus"><span class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;즐겨찾기</div></span>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		        <li class = "menus"><span class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;사원관리</div></span>
		        	<ul class="submenu">
		        		<li><a href="memberInsertForm.puvg">사원 등록</a></li>
		        		<li><a href="memberSelectAll.puvg?&nowpage=1">사원 관리</a></li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
             </ul>
		</div>
		
	</body>
</html>