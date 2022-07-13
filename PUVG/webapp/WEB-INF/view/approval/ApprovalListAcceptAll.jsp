<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="main.puvg.approval.vo.Appr1DocVO"%>  
<%@ page import="java.util.List"%>

<%
request.setCharacterEncoding("UTF-8");
%>
<%
	Object obj = request.getAttribute("listAll");
	List<Appr1DocVO> list = (List<Appr1DocVO>) obj;
	
	int nCnt = list.size();
	int sums = 0;
%>

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
	
	</script>
	<style>
	  *{
	    font-family: "paybooc-Light", sans-serif;
	  }
	
      table, td {
        border: 1px solid #000;
      }
      
      form {
		justify-content: center;
		align-items: center;
		min-height: 100vh;
      }
      
      h1{
      	text-align: right;
      }
      
      .temp{
    	background-color: #6165f8;
    	color: #fff;
      }
      
      .w-btn {
	    position: relative;
	    border: none;
	    display: inline-block;
	    padding: 10px 20px;
	    margin: 0px 0px 0px 10px;
	    border-radius: 15px;
	    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	    text-decoration: none;
	    font-weight: 600;
	    transition: 0.25s;
		}
		
	.t1{
		margin: 30px;
		justify-content: center;
		width: 1200px;
	}
	
	.mainss{
		margin: 60px 30px 0px 330px;
	}
	
	.maintable{
		height: 760px;
	}
	
    </style>
	</head>
	<body>
	<div>
		<jsp:include page="../sidebar/LeftSidebar.jsp" flush="true"/>
	</div>
	<form id="approvalList" name="approvalList">
	<div class="mainss">
	<div style="width:100%; height:100px; position:static;"></div>
	<h1 style="margin:30px">결재문서</h1>
	<input type="button" id="temp" class="w-btn temp" value="임시파일" onclick= "location.href = 'ApprovalTempSelectAll.puvg'">
	<hr>
	<div class="maintable">
		<table class="t1">
		<tr style="background-color: #8258FA; color: #fff;">
			<td style="width: 55%">결재양식</td>
			<td style="width: 20%">올린이</td>
			<td style="width: 25%">올린시간</td>
		</tr>
		<%
			for(int i = 0; i < nCnt; i++){
				Appr1DocVO avo = list.get(i);
		%>
		<tr>
			<td><a href="ApprovalAcceptSelect.puvg?vdocnum=<%= avo.getVdocnum()%>"><%= avo.getVsubj()%></a></td>
			<td><%= avo.getVname()%></td>
			<td><%= avo.getInsertdate()%></td>
		</tr>
		<%
			}
		%>
		</table>
	</div>
	</div>
	</form>
	</body>
</html>