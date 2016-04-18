<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<%
	String pid =request.getParameter("pid");
	String tab = request.getParameter("tab");
	String saveOrEdit = "新增";
	String helpTitle = "您可以在此处添加您想新增的岗位！";
	String isedit = "false";
	if(pid!=null){//编辑时使用
		isedit = "true";
		saveOrEdit = "编辑";
	    helpTitle = "您可以在此处编辑岗位！";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit %>岗位</title>
<script type="text/javascript" src="<%=contextPath %>/dwr/interface/dwrHrmEmployeeService.js"></script>
<script type="text/javascript">

window.onload = function(){
	useLoadingMassage();

	initInput('helpTitle','<%=helpTitle%>');
	saveOredit();
			
	//第一个输入框获取焦点
    document.getElementById("postname").focus();
}
	
function savepost(){
	var warnArr = new Array();
	warnArr[0] ="oposttextMust";
	warnInit(warnArr);
	var bl = validvalue('helpTitle');
	if(bl){
	 	var sposttext = DWRUtil.getValue("posttext");
		if(sposttext.length>200){
		 	setMustWarn("oposttextMust","岗位描述必须在200字以内");
		 	return;
		}
		dwrHrmEmployeeService.savePost(getpost(),savecallback);
	}
}

function saveOredit(){
    if(<%=isedit%>){
		dwrHrmEmployeeService.getPostByPk(<%=pid%>,setpagevalue);
	}
}
	
function savecallback(data){
	if(<%=isedit%>){
		if(data.success){
			alertmsg(data,"closePage()");
		}else{
			alertmsg(data);
		}
	}else{
	    if(data.success){
	    	confirmmsgAndTitle("添加岗位成功！是否想继续添加岗位？","reset();","继续添加","closePage();","关闭页面");
		}else{
			alertmsg(data);
		}
	}
}
	
function reset(){
	DWRUtil.setValue("postname","");
	DWRUtil.setValue("postenname","");
 	DWRUtil.setValue("postupname","");
 	DWRUtil.setValue("postupid","");
	DWRUtil.setValue("posttext","");
	document.getElementById("postname").focus();
}
	
function getpost(){
	var post = new Object();
	 
	if(<%=isedit%>){
		post.primaryKey = <%=pid%>;
	}
	 
	post.hrmPostName = DWRUtil.getValue("postname");
	post.hrmPostEngname = DWRUtil.getValue("postenname");
	var tmp=DWRUtil.getValue("postupid");
    if(tmp.length==0){
    	tmp="00";
    }
	post.hrmPostUpid = tmp;
	post.hrmPostUpid = tmp;
	post.hrmPostDesc = DWRUtil.getValue("posttext");
	return post;
}

function setpagevalue(data){
	if(data!=null&&data.resultList.length > 0){
		var post = data.resultList[0];
	 	DWRUtil.setValue("postname",post.hrmPostName);
		DWRUtil.setValue("postenname",post.hrmPostEngname);
		if(post.hrmUpPost!=null){
			DWRUtil.setValue("postupname",post.hrmUpPost.hrmPostName);
		}
		DWRUtil.setValue("postupid",post.hrmPostUpid);
		DWRUtil.setValue("posttext",post.hrmPostDesc);
	}else{
		alertmsg(data.message);
	}
}

function getPostUpid(){
	var box = new Sys.msgbox('拾取上级岗位','<%=contextPath%>/bams/select_takepage/select_post.jsp?type=radio&textid=postupname&valueid=postupid&getup=code','300','500');
	box.msgtitle="<b>拾取上级岗位</b><br/>选择拾取上级岗位，不拾取请‘取消’";
	var butarray = new Array();
	butarray[0] = "ok|postclickcustomer('"+box.dialogId+"');";
	butarray[1] = "cancel";
	box.buttons = butarray;
	box.show();
}

function closePage(){
	closeMDITab(<%=tab%>,"","tree");
}
</script>
</head>
<body class="inputcls">
		<div class="formDetail">
			<div class="requdiv">
				<label id="helpTitle"></label>
			</div>
			<div class="formTitle">
				<%=saveOrEdit %>岗位
			</div>
				<table class="inputtable">
					<tr>
						<th><em>*</em>&nbsp;&nbsp;岗位名称</th>
						<td>
							<input type="text" id="postname" must="岗位名称不能为空!"
								formust="postnameMust" style="width: 50%;" maxlength="20">
							<label id="postnameMust"></label>
						</td>
					</tr>
					<tr>
						<th>英文名称</th>
						<td style="text-align: left;">
							<input type="text" id="postenname" style="width:50%;" maxlength="30">
						</td>
					</tr>
					<tr>
						<th>上级岗位</th>
						<td>
							<input type="text" class="takeform" id="postupname"
								readonly="readonly" title="点击选择上级岗位" onclick="getPostUpid();"
								linkclear='postupid'>
							<input type="hidden" id="postupid">
						</td>
					</tr>
					<tr>
						<th></th>
						<td><label id="oposttextMust"></label></td>
					</tr>
					<tr>
						<th>岗位描述</th>
						<td><textarea id="posttext" style="width:50%" ></textarea></td>
					</tr>
				</table>
		</div>
		<table align="center">
			<tr>
				<td>
					<btn:btn onclick="savepost()" value="保 存 " imgsrc="../../images/png-1718.png" title="保存岗位信息"></btn:btn>
				</td>
				<td style="width: 20px;"></td>
				<td>
					<btn:btn onclick="closePage();"
						value="关 闭 " imgsrc="../../images/winclose.png" title="关闭新增页面" />
				</td>
			</tr>
		</table>
	</body>
</html>