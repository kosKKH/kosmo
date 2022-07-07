<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사원 관리</title>
		<link href="css/DefaultSetting.css" rel="stylesheet" type="text/css" />
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
		
		%>
		</script>
	</head>
	<body>
		<div>
			<jsp:include page ="../sidebar/LeftSidebar.jsp" flush ="true"/>
		</div>
	
	</body>
</html>