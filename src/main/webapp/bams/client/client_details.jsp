<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户资料</title>
<style type="text/css">
table{background-color: #E6E5E5  }
td {
	height: 25px;
}
</style>
<script type="text/javascript">
function add(){
	var box = new Sys.msgbox('添加跟进记录','<%=contextPath %>/bams/client/follow_up_log.jsp','500','360');
	box.msgtitle="<b>添加跟进记录</b>";
	var butarray = new Array();
	butarray[0] = "ok|updateName();";
	butarray[1] = "cancel";
	box.buttons = butarray;
	box.show();
}
function edit(){
	var box = new Sys.msgbox('修改跟进记录','<%=contextPath %>/bams/client/follow_up_log.jsp','500','360');
	box.msgtitle="<b>修改跟进记录</b>";
	var butarray = new Array();
	butarray[0] = "ok|updateName();";
	butarray[1] = "cancel";
	box.buttons = butarray;
	box.show();
}

</script>
</head>
<body class="inputcls" >
	<table width='100%' cellpadding='0' cellspacing='0' class='grid_table' align ='center' height ='30px;' style ='table-layout:fixed;border:0px solid #D8D6D6'>
		<tr style='BACKGROUND-IMAGE: url(/bams/images/grid_images/wbg.gif);'>
			<td align='left' class='grid_title' nowrap='nowrap'>
				<a href='javascript:void(0);'>
					<img src='/bams/images/grid_images/datalist.png' title='列表显示' onclick="changeShow(1)" border ='0' style ='vertical-align: middle;' id='dataimg'/>
				</a>
				&nbsp;<label id='sysGridTableTitle'>问卷调查</label>
			</td>
			<td align='right' class='grid_search' style="float: right;padding-bottom: 5px;" nowrap='nowrap'>
				<div style='padding-top:1px;' class='grid_btn' onclick="save()">&nbsp;
					<img class='grid_img'  src='../../images/png-1718.png'/>&nbsp;保存&nbsp;
				</div>
				<div style='padding-top:1px;' class='grid_btn'  onclick="concel()">&nbsp;
					<img class='grid_img'  src='../../images/winclose.png'/>&nbsp;取消&nbsp;
				</div>
			</td>
		</tr>
	</table>
	<div class="formDetail">
		<table class="inputtable">
			<tr>
				<td colspan="3">
					<div class="tabdiv">
						<div class="tagContentdiv">
							<div class="tagContent" id="tag0" style="height: auto;">
							   <div style="overflow: hidden;width: 70%;float: left;" >
							       <p style="color: blue">客户资料</p>
							       <table style="border: 1px solid #BDBCBC" border='0' width ='98%'>
										<tr>
										    <th>客户代码</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>客户类型</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>业务员&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>客户名称</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>国际&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>性别&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>联系电话</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>手机&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>传真&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>通讯地址</th>
									        <td>
									        	<input style="width: 250%" type="text" id="" maxlength="60">
									        </td>
									        <th></th>
									        <td></td>
										    <th>邮编&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>证件号码</th>
									        <td>
									        	<input style="width: 250%" type="text" id="" maxlength="60">
									        </td>
									        <th></th>
									        <td></td>
										    <th>证件名称</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>身份证地址</th>
									        <td>
									        	<input style="width: 400%" type="text" id="" maxlength="60">
									        </td>
										</tr>
										<tr>
										    <th>所属项目</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>到访日期</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>出生日期</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>电子邮件</th>
									        <td>
									        	<input style="width: 250%" type="text" id="" maxlength="60">
									        </td>
									        <th></th>
									        <td></td>
										    <th>客户分类</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>工作单位</th>
									        <td>
									        	<input style="width: 250%" type="text" id="" maxlength="60">
									        </td>
									        <th></th>
									        <td></td>
										    <th>职务&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>备注</th>
									        <td>
									        	<textarea style="width: 400%;height: 50px;"
									        	 rows="" cols=""></textarea>
									        </td>
										</tr>
										<tr>
											<th>
												<span style="color: blue">需求意向</span>
											</th>
										</tr>
										<tr>
										    <th>建筑性质</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>房间类型</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>朝向意见</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>景观&emsp;&emsp;</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>面积&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>单价&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>总价意向</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										</tr>
										<tr>
										    <th>居住区间</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>工作区域</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>教育程度</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>年龄段&emsp;</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>家庭结构</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>婚姻状况</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>家庭收入</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th>职业&emsp;&emsp;</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
											<th>认识途径</th>
											<td>
											  <input type="text" id=""  maxlength="20">
											</td>
										</tr>
										<tr>
										    <th>经理意见</th>
									        <td>
									        	<textarea style="width: 400%;height: 50px;"
									        	 rows="" cols=""></textarea>
									        </td>
										</tr>
										<tr>
										    <th>重复表识</th>
									        <td>
									        	<input type="text" id="" maxlength="20">
									        </td>
										    <th></th>
											<td></td>
											<th></th>
											<td>
												<label>
													<span>是否确认</span>
													<input name="Fruit" type="checkbox" value="" />
												</label> 
											</td>
										</tr>
										<tr>
										    <th>房间列表</th>
									        <td>
									        	<textarea style="width: 400%;height: 50px;"
									        	 rows="" cols=""></textarea>
									        </td>
										</tr>
							   	   </table>
							   </div>
							   <div style="overflow: hidden;width: 30%;float: left;" >
							       <p style="color: blue">跟进记录</p>
							       <table style="border: 1px solid #BDBCBC;" border='0.5' width ='98%' height="">
										<tr>
										    <th style="text-align: left;">事件名称</th>
										    <th style="text-align: left;">摘要</th>
										</tr>
										<tr style="background-color: #FFFFFF">
										    <td style="text-align: left;">电话</td>
										    <td style="text-align: left;">2016-04-12</td>
										</tr>
										<tr style="background-color: #FFFFFF">
										    <td style="text-align: left;">电话</td>
										    <td style="text-align: left;">2016-04-12</td>
										</tr>
										<tr style="background-color: #FFFFFF">
										    <td style="text-align: left;"></td>
										    <td style="text-align: left;"></td>
										</tr>
										<tr style="background-color: #FFFFFF">
										    <td style="text-align: left;"></td>
										    <td style="text-align: left;"></td>
										</tr>
										<tr style="background-color: #FFFFFF">
										    <td style="text-align: left;"></td>
										    <td style="text-align: left;"></td>
										</tr>
										<tr style="background-color: #FFFFFF">
										    <td style="text-align: left;"></td>
										    <td style="text-align: left;"></td>
										</tr>
										<tr style="background-color: #FFFFFF">
										    <td style="text-align: left;"></td>
										    <td style="text-align: left;"></td>
										</tr>
							   	   </table>
							   	   <div style='padding-top:1px;' class='grid_btn' onclick="add()">&nbsp;
										<img class='grid_img'  src='../../images/addfile_.png'/>&nbsp;添加&nbsp;
									</div>
									<div style='padding-top:1px;' class='grid_btn'  onclick="edit()">&nbsp;
										<img class='grid_img'  src='../../images/edit.gif'/>&nbsp;修改&nbsp;
									</div>
									<div style='padding-top:1px;' class='grid_btn'  onclick="dele()">&nbsp;
										<img class='grid_img'  src='../../images/winclose.png'/>&nbsp;删除&nbsp;
									</div>
							   </div>
							</div>					
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>