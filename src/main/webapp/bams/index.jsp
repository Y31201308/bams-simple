<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<%
SessionUser sessionUser = (SessionUser)LoginContext.getSessionValueByLogin(request);
List<SysMethodInfo> userModuleMethods = sessionUser.getUserModuleMethods();//个人功能模块
int msize = userModuleMethods.size();
int height = ConstWords.getProjectChangeHeight(msize);
String mid = request.getParameter("mid");	//跳转模块代码
String titname = SystemConfig.getParam("bams.sys.name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=titname %></title>
		<link rel='stylesheet' type='text/css' href='<%=contextPath%>/js/tabs/tabs.css' />
		<script type="text/javascript" src="<%=contextPath%>/js/tabs/tabs.js"></script>
		<script type="text/javascript">
		window.onload = function(){
			openMDITab("<%=contextPath%>/bams/hrm/employee.jsp");
		}
		
		$(function(){
			projectOpen("<%=mid%>");
			
			$('#config').contextMenu('configMenu', {
				bindings : {
					'viewemployee' : function(t) {
						var box = new Sys.msgbox('个人信息','<%=contextPath %>/bams/employee_info.jsp','700','500');
						box.msgtitle="个人信息";
						box.show();
					},
					'editname' : function(t) {
						var box = new Sys.msgbox('修改登录用户名','<%=contextPath %>/bams/editUserNameMsg.jsp','700','400');
						box.msgtitle="<b>修改用户名</b><br/>修改登录用户名后再次登录将生效!";
						var butarray = new Array();
						butarray[0] = "ok|updateName();";
						butarray[1] = "cancel";
						box.buttons = butarray;
						box.show();
					},
					'editpass' : function(t) {
						var box = new Sys.msgbox('修改登录密码','<%=contextPath %>/bams/editUserPwdMsg.jsp','700','450');
						box.msgtitle="<b>修改密码</b><br/>修改登录密码后再次登录将生效!";
						var butarray = new Array();
						butarray[0] = "ok|updatepassword();";
						butarray[1] = "cancel";
						box.buttons = butarray;
						box.show();
					},
					'exit' : function(t) {
						if(window.confirm("确定要退出系统吗？")){
							location.href="<%=contextPath %>/checkSession.do";
						}
					}
				},
				menuStyle : {
					width : '100px'
				},
				itemStyle: {
				      padding: '3px 10px'
				},
				allowMouseOver : true,
				offsetx : 80
			});
		})
		
		function projectOpen(id){
			document.getElementById("methodleftfrm").src = "<%=contextPath %>/bams/index_left.jsp?mid="+id;
		}

		function updatepasswordback(data){
			if(data.success){
				confirmmsg("密码修改成功，点击确定重新登录!","repload()");
			}
		}

		function updatenamedback(data){
			if(data.success){
				confirmmsg("用户名修改成功，点击确定重新登录!","repload()");
			}
		}

		function repload(){
			location.href="<%=contextPath %>/login.jsp";
		}
		
		</script>
	</head>

	<body style="overflow:hidden;">
		
		<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td height="55" style="background:url('<%=contextPath %>/images/top-5.png') repeat-x;">
				<!-- 首页顶部开始 -->
				<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td style="padding-left:5px;padding-right:5px" valign="middle">
					<img border="0" alt="公司logo" src="<%=contextPath %>/images/syslogin.png" style="height:35px;">
				</td>
				<td valign="top" width="100%" align="right">
					<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td align="right" height="30">
								<table border="0" style="margin-right:10px;">
								<tr>
									<td style="color:#FFFFFF;">
										欢迎您：<%=sessionUser.getEmployeeName() %>&nbsp;&nbsp;
										[ 部门:<%=sessionUser.getEmployeeDeptName() %>&nbsp;&nbsp;
										岗位:<%=sessionUser.getMainPost() == null ? "管理员" : sessionUser.getMainPost().getHrmPostName() %> ]&nbsp;&nbsp;
									</td>
									<td>
										<a id="config" href="javascript:void(0);"><img src="<%=contextPath %>/images/logout.png" /></a>
									</td>
								</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="27">
					            <table style="width: 100%; table-layout: fixed;" cellSpacing="0" border="0" cellPadding="0">
					              <tr>
					                <td id="tab_left" class="pre"><a class="hidden" title="向前" href="javascript:onLefttab();">向前</a></td>
					                <td><iframe id="tabFrame" src="<%=contextPath %>/js/tabs/systabs.html" frameBorder="0" 
						                 width="100%" height="27"  name="tabs" marginWidth="0" marginHeight="0" scrolling="no" allowTransparency="true"></iframe></td>
					                <td id="tab_right" class="next"><a class="hidden" title="向后 " href="javascript:onRighttab();">向后</a></td>
					              </tr>
						        </table>
							</td>
						</tr>
					</table>
					
					<div style="display:none;" id='configMenu'>
						<ul>
							<li id='viewemployee'>查看个人信息</li>
							<li id='editname'>修改用户名</li>
							<li id='editpass'>修改密码</li>
							<li id='exit'><font color="red">退出系统</font></li>
						</ul>
					</div>
				</td>
				</tr>
				</table>
				<!-- 首页顶部结束 -->
			</td>
		</tr>
		<tr>
			<td>
			<!-- 首页中间开始 -->
			<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td id="split_l" style="width:200px;">
						<div class="div_title">功能菜单</div>
						<div class="div_content_top">
							<iframe frameborder="0" allowTransparency="true" id="methodleftfrm" width="100%" height="100%" scrolling="no" marginheight="0"></iframe>
						</div>
						<div class="div_title">模块切换</div>
						<div class="div_content_bottom" style="height:<%=height%>px;">
							<!-- 个人模块切换开始 -->
							<table cellspacing="0" cellpadding="5" align="center" border="0">
							<%
							int row = Integer.parseInt(SystemConfig.getParam("bams.show.projectchange"));
							for(int i=0;i<msize;i++){
								SysMethodInfo sysMethod =userModuleMethods.get(i);
								int counttd=0;
								if(i%row==0){
								%>
								<tr>
								<%}%>
									<td valign="middle" align="center">
									<a href="javascript:projectOpen('<%=sysMethod.getPrimaryKey()%>');">
										<img src="<%=contextPath+"/images/projectimg/"+sysMethod.getImageSrc() %>"/><br/>
										<%= StringTool.textCut(sysMethod.getMethodInfoName(), 4, "") %>
									</a>
									</td>
								<%
								counttd++;
								if((i%row ==0&&counttd%row==0)||i==userModuleMethods.size()-1){
								%>
								</tr>
								<%}%>
							<%} %>
							</table>
							<!-- 个人模块切换结束 -->
						</div>
					</td>
					<td>
				        <iframe height="100%" width="100%" marginHeight="0" frameBorder="0"
				            name="mainframe" id="mainframe" marginWidth="0" scrolling="no"></iframe>
					</td>
				</tr>
			</table>
			<!-- 首页中间结束 -->
			</td>
		</tr>
		<tr>
			<td height="30" style="background:#1C77AC;">
				<!-- 首页底部开始 -->	
				<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td style="padding-left:10px;">
							<font color="#ffffff">
							(c)2008-2014 Pinhuba BAMS精简版 Version 1.0
							</font>
						</td>
				</table>					
				<!-- 首页底部结束 -->	
			</td>
		</tr>
		</table>
	</body>
</html>