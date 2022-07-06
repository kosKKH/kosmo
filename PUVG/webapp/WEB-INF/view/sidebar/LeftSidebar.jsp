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
		</div>
	</header>
		<div id="menu" class="menu">
			<div class="logo" style="align-items: center; display: flex; justify-content: center;">
				<img Class="img" src="/PUVG/css/icons/logo.png" style="width: 60%; height: 80%"/>
			</div>
			<label for="expand-menu"><div>&nbsp;&nbsp;&nbsp;&nbsp;메뉴</div></label>
			 <input type="checkbox" id="expand-menu" name="expand-menu">
			 <ul id = "nav-v1">
			   <li class = "menus"><a href="#" class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;일정관리</div></a>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		       <li class = "menus"><a href="#" class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;웹저장소</div></a>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		        <li class = "menus"><a href="#" class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;소통게시판</div></a>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		        <li class = "menus"><a href="#" class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;결재문서</div></a>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
		        <li class = "menus"><a href="#" class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;이메일</div></a>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
			   <li class = "menus"><a href="#" class="item"><div>&nbsp;&nbsp;&nbsp;&nbsp;즐겨찾기</div></a>
		        	<ul class="submenu">
		        		<li>결재1</li>
		        		<li>결재2</li>
		        		<li>결재3</li>
		        	</ul>
		        </li>
             </ul>
		</div>
	</body>
</html>