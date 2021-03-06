<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>编辑功能目录</title>
		<%
			String sid = request.getParameter("sid");
		%>
		<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrSysProcessService.js"></script>
		<script type="text/javascript">

window.onload = function(){
	useLoadingMassage();
	initInput('helpTitle','您可以在此处编辑功能目录信息！');
	dwrSysProcessService.getSysMethodInfoByPK('<%=sid%>',setpagevalue);
}
	
function saveSysMethodInfo(){
	var warnArr = new Array();
	warnArr[0] ="methodInfoNameMust";
	warnArr[1] ="methodNoMust";
	warnInit(warnArr);
	var bl = validvalue('helpTitle');
	
	if(bl){
	    Btn.close();
		dwrSysProcessService.updateSysMethodInfo(getSysMethodInfo(),savecallback);
	}
}

function savecallback(data){
    Btn.open();//开放按钮
	if(data.success){
		alertmsg(data,"reload()");
	}else{
		alertmsg(data);
	}
}

function reload(){
    closeMDITab(<%= request.getParameter("tab")%>,"","tree");
}
	
function getSysMethodInfo(){
	 var info = new Object();
     info.primaryKey = DWRUtil.getValue("primaryKey");
	 info.methodInfoName = DWRUtil.getValue("methodInfoName");
	 info.methodInfoEngname =  DWRUtil.getValue("methodInfoEngname");
	 info.levelUnit = DWRUtil.getValue("levelUnitId");
	 info.imageSrc = DWRUtil.getValue("imageSrc");
	 info.methodNo = DWRUtil.getValue("methodNo");
	 info.methodLevel =  DWRUtil.getValue("methodLevel");
	 info.isAction = getRadioValueByName("isAction");
	 info.methodSign =  DWRUtil.getValue("methodSign");
	 info.methodUri = DWRUtil.getValue("methodUri");
	 info.methodMsg =  DWRUtil.getValue("methodMsg");
	 info.methodPages =  DWRUtil.getValue("methodPages");
	 return info;
}

function setpagevalue(data){
	if(data != null && data.resultList.length > 0){
 			var info = data.resultList[0];
 			DWRUtil.setValue("primaryKey",info.primaryKey);
 			DWRUtil.setValue("methodInfoName",info.methodInfoName);
		    DWRUtil.setValue("methodInfoEngname",info.methodInfoEngname);
		    if(info.upSysMethodInfo != null){
		    	DWRUtil.setValue("levelUnitName",info.upSysMethodInfo.methodInfoName);
		    }
		    DWRUtil.setValue("levelUnitId",info.levelUnit);
	        DWRUtil.setValue("imageSrc",info.imageSrc);
	        DWRUtil.setValue("methodNo",info.methodNo);
	        DWRUtil.setValue("methodLevel",info.methodLevel);
	        setRadioValueByName("isAction",info.isAction);
		    DWRUtil.setValue("methodSign",info.methodSign);
		    DWRUtil.setValue("methodUri",info.methodUri);
            DWRUtil.setValue("methodMsg",info.methodMsg);
            DWRUtil.setValue("methodPages",info.methodPages);
 		}
 		
}

function getImg(){
	var box = SEL.getImg("projectimg","imageSrc");
    box.show();
}
</script>
	</head>
	<body class="inputcls">
		<div class="formDetail">
			<div class="requdiv">
				<label id="helpTitle"></label>
			</div>
			<div class="formTitle">
				编辑功能信息
			</div>
			<div>
				<table class="inputtable">
					<tr>
						<th width="15%">
							<em>* </em>功能编号
						</th>
						<td>
							<input type="text" id="primaryKey" readonly="readonly">
						</td>
						<th width="15%">
							<em>* </em>功能名称
						</th>
						<td>
							<input type="text" id="methodInfoName" maxlength="50" must="功能名称不能为空。" formust="methodInfoNameMust">
							<label id="methodInfoNameMust"></label>
						</td>
					</tr>
					
					<tr>
						<th>
							功能层次
						</th>
						<td>
							<input type="text" id="methodLevel" readonly="readonly">
						</td>
						<th>
							<em>* </em>显示顺序
						</th>
						<td>
							<input type="text" id="methodNo" maxlength="9" class="numform" formust="methodNoMust" must="显示顺序不能为空">
							<label id="methodNoMust"></label>
						</td>
					</tr>
					
					
					<tr>
						<th>
							上级功能
						</th>
						<td>
							<input type="text" id="levelUnitName" readonly="readonly">
							<input type="hidden" id="levelUnitId" >
						</td>
						
						<th>
							英文名称
						</th>
						<td>
							<input type="text" id="methodInfoEngname" maxlength="50">
						</td>
					</tr>
					<tr>
						<th>
							是否有效
						</th>
						<td colspan="3">
							 <%=UtilTool.getRadioOptionsByEnum(EnumUtil.SYS_ISACTION.getSelectAndText(""),"isAction")%>
						</td>
					</tr>
					<tr>
						<th>
							功能标识
						</th>
						<td>
							<input type="text" id="methodSign" maxlength="50">
						</td>
						<th>
							功能图标
						</th>
						<td>
							<input type="text" id="imageSrc" maxlength="50" class="takeform" ondblclick="getImg()"/>
							<font class="tip">双击选择，新图片放到images/projectimg目录</font>
						</td>
					</tr>
					
					<tr>
						<th>
							跳转路径
						</th>
						<td colspan="3">
							<input type="text" id="methodUri" style="width:50%">
						</td>
					</tr>
					<tr>
						<th>
							功能描述
						</th>
						<td colspan="3">
							<textarea id="methodMsg" style="width:50%"></textarea>
						</td>
					</tr>
					<tr>
						<th>
							功能相关页面
						</th>
						<td colspan="3">
							<textarea id="methodPages" style="width:50%"></textarea>
						</td>
					</tr>
					
				</table>
				<br />
			</div>
		</div>
		<br />
		<table align="center">
			<tr>
				<td>
					<btn:btn onclick="saveSysMethodInfo();" value="保 存 "
						imgsrc="../../images/png-1718.png" title="保存功能目录"></btn:btn>
				</td>
				<td style="width: 10px;"></td>
				<td>
					<btn:btn onclick="reload()" value="关 闭 "
						imgsrc="../../images/winclose.png" title="关闭当前页面"></btn:btn>
				</td>
			</tr>
		</table>
	</body>
</html>