<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<script type="text/javascript" src="<%=contextPath %>/dwr/interface/dwrSysProcessService.js"></script>
</head>
<body class="inputcls">
<div class="formDetail">
	<div class="formTitle">修改跟进记录</div>
	<div>
		<table class="inputtable" style="background-color: #E6E5E5">
			<tr>
				<th>发送时间</th>
				<td width="50%">
					<input type="text"  value=""/>
				</td>
				<th>事件名称</th>
				<td>
					<input type="text"  id="newusername" maxlength="50" style="ime-mode:disabled;" must="新的用户名不能为空" formust="onewusernameMust">
				</td>
			</tr>
			<tr>
				<th>摘要&emsp;&emsp;</th>
				<td>
					<textarea style="width: 230%;height: 150px;" rows="" cols=""></textarea>
				</td>
			</tr>
		</table>
	</div>
</div>
<br/>
</body>
</html>