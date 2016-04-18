<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<%
String pid = request.getParameter("pid");
String tab = request.getParameter("tab");
String saveOrEdit = "新增";
String helpTitle = "您可以在此处添加系统参数！";
String isedit = "false";
if(pid != null){
	isedit = "true";
	saveOrEdit = "编辑";
    helpTitle = "您可以在此处编辑系统参数！";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath %>/dwr/interface/dwrSysProcessService.js"></script>
<title><%=saveOrEdit%>参数</title>

<script type="text/javascript">
window.onload = function(){
	initInput('helpTitle','<%=helpTitle%>');
	if(<%=isedit%>){
		dwrSysProcessService.getSysParamByPk(<%=pid%>,setpagevalue);
	}
}

function setpagevalue(data){
	if(data.success&&data.resultList.length>0){
		var tmp = data.resultList[0];
		DWRUtil.setValue("paramindex",tmp.paramIndex);
		DWRUtil.setValue("paramname",tmp.paramTitle);
		DWRUtil.setValue("paramvalue",tmp.paramValue);
		DWRUtil.setValue("paramremark",tmp.paramRemark);
		setSelectValue("paramtype",tmp.paramType);
		DWRUtil.setValue("paramtypevalue",tmp.paramTypeValue);
	}else{
		alertmsg(data);
	}
}

function saveparam(){
	var bl = validvalue('helpTitle');
	if(bl){
		var par = getparam();
		dwrSysProcessService.saveSysparam(par,savecallback);
	}
}

function savecallback(data){
	if(<%=isedit%>){
		if(data.success){
			alertmsg(data,"closePage();");
		}else{
			alertmsg(data);
		}
	}else{
	    if(data.success){
	    	confirmmsgAndTitle("添加系统参数成功！是否想继续添？","reset();","继续添加","closePage();","关闭页面");
		}else{
			alertmsg(data);
		}
	}
}

function reset(){
	DWRUtil.setValue("paramindex","");
	DWRUtil.setValue("paramname","");
	DWRUtil.setValue("paramvalue","");
	DWRUtil.setValue("paramremark","");
	document.getElementById("paramtype").selectedIndex =0;
	DWRUtil.setValue("paramtypevalue","");
}

function getparam(){
	var par= new Object();
	if(<%=isedit%>){
		par.primaryKey = <%=pid%>;
	}
	par.paramIndex = DWRUtil.getValue("paramindex");
	par.paramTitle = DWRUtil.getValue("paramname");
	par.paramValue = DWRUtil.getValue("paramvalue");
	par.paramRemark = DWRUtil.getValue("paramremark");
	par.paramType = DWRUtil.getValue("paramtype"); 
	par.paramTypeValue = DWRUtil.getValue("paramtypevalue"); 
	return par;
}

function closePage(){
	closeMDITab(<%=tab%>);
}	
</script>
</head>
<body class="inputcls">
<div class="formDetail">
<div class="requdiv"><label id="helpTitle"></label></div>
<div class="formTitle">运行参数</div>
<table class="inputtable">
	<tr>
	<th><em>*</em>参数标识</th>
	<td><input type="text" id="paramindex" must="请输入参数标识"></td>
	<td style="color: #808080">参数标识请不要重复!</td>
	</tr>
	<tr>
	<th><em>*</em>参数名称</th>
	<td  colspan="2"><input type="text" id="paramname" must="请输入参数名称"  style="width: 50%;"></td>
	</tr>
	<tr>
	<th><em>*</em>参数值</th>
	<td  colspan="2"><input type="text" id="paramvalue" must="请输入参数值"  style="width: 50%;" maxlength="25"></td>
	</tr>
	<tr>
	<th><em>*</em>参数类型</th>
	<td>
	<select id="paramtype">
	<%=UtilTool.getSelectOptionsByEnum(EnumUtil.SYS_PARAM_TYPE.getSelectAndText("")) %>
	</select>
	</td>
	<td style="color: #808080">
	控制公司在设置参数时显示的输入组件样式
	</td>
	</tr>
	<tr>
	<th>类型限制</th>
	<td>
	<input type="text" id="paramtypevalue" maxlength="300" style="width: 50%">
	</td>
	<td>
	<ul style="color: #808080;margin-top: 0;margin-bottom: 0;margin-left: 0">
	<li>1.普通输入框类型请输入要求字符串的最小长度，不能超过25个字符。</li>
	<li>2.数字框类型请输入数值范围,以 '-' 隔开。</li>
	<li>3.下拉框类型请在此处输入下拉框值,以 ',' 分隔。</li>
	</ul>
	</td>
	</tr>
	<tr>
	<th><em>*</em>参数说明</th>
	<td  colspan="2">
	<textarea id="paramremark"  style="width: 70%;" must="请输入参数说明"></textarea>
	</td>
	</tr>
	</table>
</div>

<table align="center">
<tr>
<td>
<btn:btn onclick="saveparam();" value=" 保 存 "></btn:btn>
</td>
<td style="width: 15px;"></td>
<td>
<btn:btn onclick="closePage();" value=" 关 闭 "></btn:btn>
</td>
</tr>
</table>
</body>
</html>