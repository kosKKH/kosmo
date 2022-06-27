<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="main.puvg.emp.vo.Empvo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	List<Empvo> list = (List<Empvo>)request.getAttribute("selectall");
	for(int i=0; i<list.size(); i++) {
		Empvo evo = list.get(i);
		%>
		<%= evo.getEmpno() %>
		<%= evo.getEname() %>
		<%= evo.getJob() %>
		<%= evo.getMgr() %>
		<%= evo.getHiredate() %>
		<%= evo.getSal() %>
		<%= evo.getComm() %>
		<%= evo.getDeptno() %> <br>
		
		<%
	}
%>
</body>
</html>