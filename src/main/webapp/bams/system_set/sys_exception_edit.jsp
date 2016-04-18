<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<%
String sysExceptionPk = request.getParameter("sysExceptionPk");
String tab = request.getParameter("tab");
SessionUser sUser = (SessionUser) LoginContext.getSessionValueByLogin(request);
String userName = sUser.getUserName();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrSysProcessService.js"></script>
<link href="<%=contextPath%>/js/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/js/umeditor/umeditor.config.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/umeditor/umeditor.js"></script>
<title>处理异常界面</title>
<script type="text/javascript">
window.onload = function(){
	editor = UM.getEditor('processContext');
	
	initInput('helpTitle','您可以在这里处理系统异常');
	if(<%=sysExceptionPk%> != null){
	    dwrSysProcessService.getSysExceptionByPk(<%=sysExceptionPk%>,setPageValue);
	}
}

function setPageValue(data){
	 if(data.success && data.resultList.length>0){
          var sysExcp = data.resultList[0];
          DWRUtil.setValue("userName",sysExcp.userInfo.userName);
          DWRUtil.setValue("exceptionClass",sysExcp.exceptionClass);	        
          DWRUtil.setValue("exceptionMsg",sysExcp.exceptionMsg);	          
          DWRUtil.setValue("exceptionDate",sysExcp.exceptionDate);
          DWRUtil.setValue("exceptionContext",sysExcp.exceptionContext);
          editor.ready(function(){editor.setContent(sysExcp.processContext);})
	  }
}

function getSysExceptionInfo(){
	var sysExcp = new Object();
   	if(<%=sysExceptionPk%> != null){
		sysExcp.primaryKey = <%=sysExceptionPk%>;
    }
	sysExcp.processName = DWRUtil.getValue("processName");
	sysExcp.processContext = editor.getContent();
	return sysExcp;
}

function save(){
    var bl = validvalue('helpTitle');
	if(bl){
         dwrSysProcessService.updateSysException(getSysExceptionInfo(),saveCallback);
    }
}

function saveCallback(data){
    alertmsg(data,"closePage()");
}
function closePage(){
	closeMDITab(<%=tab%>);
}
</script>
</head>

<body class="inputcls">
<div class="formDetail">
<div class="requdiv"><label id="helpTitle"></label></div>
<div class="formTitle">处理系统异常</div>
<table class="detailtable">
	<tr>
		<th width="15%">用户名称</th>
		<td id="userName" colspan="3" class="detailtabletd"></td>
	</tr>
	<tr>
	<tr>
		<th>异常类型</th>
		<td id="exceptionClass" colspan="3" class="detailtabletd"></td>
	</tr>
	<tr>
		<th>异常消息</th>
		<td id="exceptionMsg" class="detailtabletd"></td>
	</tr>
	<tr>
		<th>异常日期</th>
		<td id="exceptionDate" class="detailtabletd"></td>
	</tr>
	<tr>
		<th valign="top">异常内容</th>
		<td colspan="3" id="exceptionContext" class="detailtabletd"></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td colspan="3">
		<%=userName %>
		<input type="hidden" id="processName" value="<%=userName %>">
		</td>
	</tr>
	<tr>	
		<th><em>* </em>处理原因</th>
		<td colspan="3">
		<script type="text/plain" id="processContext" style="width:90%;height:280px;"></script>
		</td>
	</tr>
</table>
</div>

<table align="center">
<tr>
	<td><btn:btn onclick="save();" value=" 确  定 " /></td>
	<td style="width: 20px;"></td>
	<td><btn:btn onclick="closePage();" value=" 关 闭 "/></td>
</tr>
</table>
</body>
</html>