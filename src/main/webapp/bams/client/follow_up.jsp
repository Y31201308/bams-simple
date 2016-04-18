<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
</head>
<script type="text/javascript" src="<%=contextPath %>/dwr/interface/dwrSysProcessService.js"></script>
<script type="text/javascript">
function create(){
	var box = new Sys.msgbox('添加跟进记录','<%=contextPath %>/bams/client/input_client_info.jsp','500','360');
	box.msgtitle="<b>添加跟进记录</b>";
	var butarray = new Array();
	butarray[0] = "ok|goto_details();";
	butarray[1] = "cancel";
	box.buttons = butarray;
	box.show();
}
<%-- function create(){
	window.location.href = "<%=contextPath%>/bams/client/client_details.jsp";
} --%>

function detail(){
	window.location.href = "<%=contextPath%>/bams/client/client_details.jsp";
}

function del(id){
	confirmmsg("确定要删除编组吗?","delok("+id+")");
}
</script>
<body>
	<table width='100%' cellpadding='0' cellspacing='0' class='grid_table' align ='center' height ='100%' style ='table-layout:fixed;border:0px solid #D8D6D6'>
		<tr style='BACKGROUND-IMAGE: url(/bams/images/grid_images/wbg.gif);'>
			<td align='left' class='grid_title' nowrap='nowrap'>
				<a href='javascript:void(0);'>
					<img src='/bams/images/grid_images/datalist.png' title='列表显示' onclick="changeShow(1)" border ='0' style ='vertical-align: middle;' id='dataimg'/>
				</a>
				&nbsp;<label id='sysGridTableTitle'>客户管理</label>
			</td>
			<td align='right' class='grid_search' nowrap='nowrap'>
				查询条件&nbsp;&nbsp;
				<select style ="width:auto;top:0px;left:0px;" id='simpleQueryParam' >
					<option value='groupName'>组名称</option>
				</select>
				客户名称收索
				&nbsp;<input type='text' class='niceform' onkeydown='if(event.keyCode==13)queryData();' id='simpleQueryValue'/>
				&nbsp;<img id='searchImg' onclick='queryData();' class='grid_img' src='/bams/images/grid_images/magnifier.png' alt='查询' title='查询'/>
			</td>
		</tr>
		<tr style='BACKGROUND-IMAGE: url(/bams/images/grid_images/bg.gif);'>
			<td align='left' class='grid_fun' colspan='2' style ='padding-left:5px;' valign='middle'>
				<div style='padding-top:1px;' class='grid_btn' onmouseover ='this.className ="grid_btn_hover"' 
				onmouseout ='this.className ="grid_btn"'  onclick="create()">&nbsp;
					<img class='grid_img'  src='/bams/images/grid_images/add.png'/>&nbsp;增加&nbsp;
				</div>
				<div style='padding-top:1px;' class='grid_btn' onmouseover ='this.className ="grid_btn_hover"' 
				onmouseout ='this.className ="grid_btn"'  onclick="detail()">&nbsp;
					<img class='grid_img'  src='/bams/images/grid_images/info1.png'/>&nbsp;详情&nbsp;
				</div>
				<div style='padding-top:1px;' class='grid_btn' onmouseover ='this.className ="grid_btn_hover"' 
				onmouseout ='this.className ="grid_btn"'   onclick="delbatch()">&nbsp;
					<img class='grid_img'  src='/bams/images/grid_images/close.png'/>&nbsp;删除&nbsp;
				</div>
			</td>
		</tr>
		<tr valign='center'>
			<td colspan='2' valign='top' id='allshowtd' style='height:100%;'>
				<div style='overflow:auto;width:100%;' id ='allshowdiv'>
					<div id='listShow' width='100%'>
						<table width='100%' cellSpacing='0' cellPadding='0'>
							<tr>
								<td width='30' valign='top'>
									<table class='tableStyleSolidLine' cellSpacing='0' cellPadding='4' width='100%' align='center' id='rowCountTable'>
										<tr>
											<td style='background-image: url(/bams/images/grid_images/fhbg.gif);'>
												<div class='tabimgdiv'>
													<input style='margin:0px;padding:0px;height:13px;width:13px;' 
													type='checkbox' title='全选/取消' id='rowCountTableTdTopCheck' 
													onclick='rowCountTableTdTopCheckFun(this);'/>
												</div>
											</td>
										</tr>
									</table>
									<table class='tableStyleSolidLine2' cellSpacing='0' cellPadding='4' width='100%' align='center' border='0' id='rowCountTableBlank'>
										<tr id="gridcheckbox_58" style="background: rgb(245, 245, 245) none repeat scroll 0% 0%;">
											<td class="tabStyletd" style="height: 30px;">
												<div class="tabimgdiv">
													<input type="checkbox" onclick="" value="58" 
													style="margin:0px;padding:0px;height:13px;width:13px;">
												</div>
											</td>
										</tr>
										<tr id="gridcheckbox_58" style="background: rgb(245, 245, 245) none repeat scroll 0% 0%;">
											<td class="tabStyletd" style="height: 30px;">
												<div class="tabimgdiv">
													<input type="checkbox" onclick="" value="58" 
													style="margin:0px;padding:0px;height:13px;width:13px;">
												</div>
											</td>
										</tr>
									</table>
								</td>
								<td width='100%' valign='top'>
									<table class='tableStyleSolidLine' cellSpacing='0' cellPadding='4' width='100%' align='center' id='tableResult'>
										<tr>
											<td class='tableTitle1' nowrap >
												序号&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												项目名称&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												客户名称&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												客户代码&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												性别&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												联系电话&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												手机&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												到访日期&nbsp;
												<span class='sortarrow'></span>
											</td>
											<td class='tableTitle1' nowrap >
												跟进日期&nbsp;
												<span class='sortarrow'></span>
											</td>
										</tr>
										
										<tr class="tableContent001">
											<td  style="height: 30px; text-align: center;">
												<nobr>1</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>佳琪花园</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>王先生</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>182</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>男</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>4008899</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>156542565254</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>2015-04-06</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>2015-04-09</nobr>
											</td>
										</tr>
										<tr class="tableContentAlternating001">
											<td  style="height: 30px; text-align: center;">
												<nobr>2</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>佳琪花园</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>王先生</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>182</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>男</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>4008899</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>156542565254</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>2015-04-06</nobr>
											</td>
											<td  style="height: 30px; text-align: center;">
												<nobr>2015-04-09</nobr>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</td>
		</tr>
		<tr style='background-image: url(/bams/images/grid_images/wbg.gif);'>
			<td align='left' class='grid_refresh' nowrap='nowrap'>
				<label id='refreshLab'>
					<div id='refreshDiv'>
						<img class='grid_img' src='/bams/images/grid_images/refresh.png' onclick='goPage();' alt='刷新' title='刷新'/>
						&nbsp;<img class='grid_img'  src='/bams/images/grid_images/line.gif'/>
						&nbsp;当前显示 
						<select id='showRows' style="font:13px '宋体';text-align:center;width:auto;top:0px;left:0px;" onchange='queryData();'>
							<option value='30'>30</option>
							<option value='50' selected ='selected'>50</option>
							<option value='100'>100</option>
							<option value='150'>150</option>
							<option value='200'>200</option>
						</select> 
						条，共&nbsp;<label id='rowCount'>0</label>
						&nbsp;条记录
					</div>
				</label>
			</td>
			<td align='right' class='grid_pager' style='cursor: default;' nowrap='nowrap'>&nbsp;
				<img class='grid_img'  src='/bams/images/grid_images/line.gif'/>&nbsp;
				<img src='/bams/images/grid_images/first_.gif' alt='第一页' title='第一页' id='firstPage'/>
				<img src='/bams/images/grid_images/prev_.gif' alt='上一页' title='上一页' id='prevPage'/>&nbsp;
				<img class='grid_img'  src='/bams/images/grid_images/line.gif'/>&nbsp;第&nbsp;
				<label class='grid_page_btn' id='currentPage' onclick='selectcpage(this);' onmouseover ='this.className ="grid_page_btn_hover"' onmouseout ='this.className ="grid_page_btn"' title='快速跳转'>
				</label>&nbsp;页&nbsp;
				<img class='grid_img'  src='/bams/images/grid_images/line.gif'/>&nbsp;共&nbsp;
				<label id='pageCount'> 0 </label>&nbsp;页&nbsp;
				<img class='grid_img'  src='/bams/images/grid_images/line.gif'/>&nbsp;
				<img src='/bams/images/grid_images/next_.gif' alt='下一页' title='下一页' id='nextPage'/>
				<img src='/bams/images/grid_images/last_.gif' alt='最后一页' title='最后一页' id='lastPage'/>&nbsp;
				<img class='grid_img'  src='/bams/images/grid_images/line.gif'/>&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>