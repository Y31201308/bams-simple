<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<%
String lid = request.getParameter("lid");
String tab = request.getParameter("tab");
String saveOrEdit = "新增";
String helpTitle = "您可以在此处添加业务字典！";
String isedit = "false";
if(lid != null){
	isedit = "true";
	saveOrEdit = "编辑";
    helpTitle = "您可以在此处编辑业务字典！";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=contextPath %>/dwr/interface/dwrSysProcessService.js"></script>
<title><%=saveOrEdit %>业务字典</title>
</head>
<body class="inputcls">
<div class="formDetail">
<div class="requdiv"><label id="helpTitle"></label></div>
<div class="formTitle"><%=saveOrEdit %>业务字典</div>
	<table class="inputtable">
	<tr>
	<th>上级名称</th>
	<td><input type="text" class="takeform" id="libupname"  readonly="readonly" title="点击选择上级名称" onclick="getupcode();" linkclear ="libupcode">
	<input type="hidden" id="libupcode">
	</td>
	<th><em>*</em>业务名称</th>
	<td><input type="text" id="linname" must="业务名称不能为空">
	<input type="hidden" id="lincode">
	</td>
	</tr>
	<tr>
	<th>英文名称</th>
	<td>
	<input type="text" id="linenname">
	</td>
	<th><em>*</em>是否有效</th>
	<td>
	<select id="libisvalid">
	<%=UtilTool.getSelectOptionsByEnum(EnumUtil.SYS_ISACTION.getSelectAndText("")) %>
	</select>
	</td>
	</tr>
	<tr>
	<th>备 注</th>
	<td  colspan="3">
	<textarea id="libremark" style="height: 80px;"></textarea>
	</td>
	</tr>
	</table>
</div>

<table align="center">
<tr>
<td>
<btn:btn onclick="savelib();" value=" 保 存 "></btn:btn>
</td>
<td style="width: 15px;"></td>
<td>
<btn:btn onclick="closePage();" value=" 关 闭 "></btn:btn>
</td>
</tr>
</table>
<script type="text/javascript">
window.onload = function(){
	initInput('helpTitle','<%=helpTitle%>');
	if(<%=isedit%>){//编辑
		dwrSysProcessService.getSysLibraryInfoByPk(<%=lid%>,setpagevalue);
	}
}
function setpagevalue(data){
	if(data!=null){
		var tmp =data.resultList[0];
		DWRUtil.setValue("linname",tmp.libraryInfoName);
		DWRUtil.setValue("linenname",tmp.libraryInfoEngname);
		DWRUtil.setValue("lincode",tmp.libraryInfoCode);
		if(tmp.upSysLibraryInfo!=null){
			DWRUtil.setValue("libupcode",tmp.upSysLibraryInfo.libraryInfoCode);
			DWRUtil.setValue("libupname",tmp.upSysLibraryInfo.libraryInfoName);
		}
		setSelectValue("libisvalid",tmp.libraryInfoIsvalid);
		DWRUtil.setValue("libremark",tmp.libraryInfoDesc);
		
		document.getElementById("libupname").disabled=true;
		document.getElementById("libupname").title ="编辑时不可修改上级编码";
	}
}

function getupcode(){
	var box = new Sys.msgbox('拾取上级编码','<%=contextPath%>/bams/select_takepage/select_library.jsp?name=libupname&code=libupcode','300','500');
	box.msgtitle="<b>业务字典上级编码拾取</b><br/>选择拾取上级编码，不拾取请‘取消’";
	var butarray = new Array();
	butarray[0] = "ok|gettreecheckcustom('"+box.dialogId+"');";
	butarray[1] = "cancel";
	box.buttons = butarray;
	box.show();
}

function savelib(){
	var bl = validvalue('helpTitle');
	if(bl){
		var library = getLibrary();
		if(<%=isedit%>){
			dwrSysProcessService.updateSysLibraryInfo(library,updatacallback);
		}else{
			dwrSysProcessService.saveSysLibrayInfo(library,methodcallback);
		}
	}
}

function updatacallback(data){
	if(data.success){
		alertmsg(data,"closePage()");
	}else{
		alertmsg(data);
	}
}

function methodcallback(data){
	if(data.success){
		confirmmsgAndTitle("业务字典添加成功！是否继续添加","sevent();","继续添加","closePage();","关闭页面");
	}else{
		alertmsg(data);
	}
}

function sevent(){
	DWRUtil.setValue("linname","");
	DWRUtil.setValue("linenname","");
	DWRUtil.setValue("libupcode","");
	DWRUtil.setValue("libupname","");
	document.getElementById("libisvalid").selectedIndex = 0;
	DWRUtil.setValue("libremark","");
}

function getLibrary(){
	var library = new Object();
	if(<%=isedit%>){//编辑
		library.primaryKey = <%=lid%>;
		library.libraryInfoCode = DWRUtil.getValue("lincode");
	}
	library.libraryInfoName = DWRUtil.getValue("linname");
	library.libraryInfoEngname = DWRUtil.getValue("linenname");
	var code = DWRUtil.getValue("libupcode");
	if(code.length==0){
		code ="00";
	}
	library.libraryInfoUpcode = code; 
	library.libraryInfoIsvalid = DWRUtil.getValue("libisvalid");
	library.libraryInfoDesc = DWRUtil.getValue("libremark");
	return library;
}

function closePage(){
	closeMDITab(<%=tab%>,"","tree");
}
</script>
</body>
</html>