<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入客户资料</title>
<script type="text/javascript" src="<%=contextPath %>/dwr/interface/dwrSysProcessService.js"></script>
</head>
<body class="inputcls">
<div class="formDetail">
	<div style="color: red;margin-bottom: 50px;padding:10px;">第一步输入客户名称：</div>
	<div style="margin-bottom: 50px;">
		<table class="inputtable">
			<tr>
				<th>客户名称</th>
				<td>
					<input id="client_name" style="width: 95%;" type="text"  id="" maxlength="50" >
				</td>
			</tr>
		</table>
	</div>
	<div>
		<p>&emsp;说明：</p>
		<p>&emsp;&emsp;&emsp;引用同名客户资料点击“确定”</p>
		<p>&emsp;&emsp;&emsp;退出本次操作点击“关闭”</p>
	</div>
</div>
<script type="text/javascript">
function goto_details(){
	var client_name = $("#client_name");
	if(client_name.val() == ''){
		alert("请输入客户名称！");
		return ;
	}else{
		//window.location.href = "<%=contextPath%>/bams/client/client_details.jsp";
	}
}
</script>
</body>
</html>