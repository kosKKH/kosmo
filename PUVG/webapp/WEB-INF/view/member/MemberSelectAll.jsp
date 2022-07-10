<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "main.puvg.member.vo.MemberVO" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사원 관리</title>
		<link href="css/MemberSelectAll.css" rel="stylesheet" type="text/css" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		<%
			HttpSession Session = request.getSession(false);
			String VNAME = (String)Session.getAttribute("VNAME");
			int VAUTHORITY = (Integer)Session.getAttribute("VAUTHORITY");
			
			if (VAUTHORITY == 0) {
				%>
				alert("권한이 없습니다.");
				history.go(-1);
				<%
			}
			List<MemberVO> list1 = (List<MemberVO>)request.getAttribute("selectall");
			MemberVO mvo1 = list1.get(0);
			int viewpage = 5;
			int nowpage = Integer.parseInt(mvo1.getNowpage());
			int totalcount = Integer.parseInt(mvo1.getTotalcount());
			
			int max = totalcount/15 +1;
		%>
		$(document).ready(function(){
			$(document).on("click",".member_info",function(){
				alert($(this).children('.vnum').text());
			})
		})
		</script>
	</head>
	<body>
		<div>
			<jsp:include page ="../sidebar/LeftSidebar.jsp" flush ="true"/>
		</div>
		<div class="main_container">
			<div id="selectall_div">
				<div id="member_table">
					<div id="top_div">
						<span class="tt">사원번호</span>
						<span class="tt">이름</span>
						<span class="tt">생년월일</span>
						<span class="tt">나이</span>
						<span class="tt">부서</span>
						<span class="tt">직급</span>
						<span class="tt">고용일</span>
						<span class="tt">연락처</span>
						<span class="tt">근무상태</span>
						<span class="tt">권한</span>
					</div>
					
					<%
						List<MemberVO> list = (List<MemberVO>)request.getAttribute("selectall");
					
						for(int i=0; i<list.size(); i++) {
							MemberVO mvo = list.get(i);
							
							Date date = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
							String a = sdf.format(date);
							String vage = mvo.getVbirth().substring(0,4);
							int age = Integer.parseInt(a) - Integer.parseInt(vage);
					%>
						<div class="member_info">
							<span class="vnum"><%= mvo.getVnum() %></span>
							<span class="tt"><%= mvo.getVname() %></span>
							<span class="tt"><%= mvo.getVbirth() %></span>
							<span class="tt"><%= age %></span>
							<span class="tt"><%= mvo.getVdept() %></span>
							<span class="tt"><%= mvo.getVrank() %></span>
							<span class="tt"><%= mvo.getVhiredate() %></span>
							<span class="tt"><%= mvo.getVph() %></span>
							<span class="tt"><%= mvo.getVdeleteyn() %></span>
							<span class="tt"><%= mvo.getVauthority() %></span>
						</div>
					<%
						}
					%>
				</div>
			</div>
			<table id="paging_table">
				<tr>
					<td colspan="12">
						<p align="center">
							<a href = "memberSelectAll.puvg?&nowpage=1">◁◁</a>
			<% 
				if (viewpage > max) {
					viewpage = max;
				}
				if(nowpage-2 <= 0){
					for(int i = 1; i<=viewpage; i++){
						if(nowpage == i){
							%>
							<a href  = "memberSelectAll.puvg?&nowpage=<%=i%>"><b><%= i + " " %></b></a>
							<%
						} else {
							%>
									<a href = "memberSelectAll.puvg?&nowpage=<%=i%>"><%= i + " " %></a>
							<%
						}
					}
				} else if (nowpage+2 > max) {
					for(int i = max-(viewpage-1); i<=max; i++){
						if(nowpage == i){
							%>
							<a href  = "memberSelectAll.puvg?&nowpage=<%=i%>"><b><%= i + " " %></b></a>
							<%
						} else {
							%>
									<a href = "memberSelectAll.puvg?&nowpage=<%=i%>"><%= i + " " %></a>
							<%
						}
					}
				} else {
					for(int i = nowpage-2; i<(nowpage + viewpage -2); i++){
						if(nowpage == i){
							%>
							<a href  = "memberSelectAll.puvg?&nowpage=<%=i%>"><b><%= i + " " %></b></a>
							<%
						} else {
			%>
						<a href = "memberSelectAll.puvg?&nowpage=<%=i%>"><%= i + " " %></a>
			<%
						}
					}
				}
			%>
			
							<a href = "memberSelectAll.puvg?&nowpage=<%=max%>">▷▷</a>
						</p>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>