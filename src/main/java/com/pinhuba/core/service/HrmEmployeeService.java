package com.pinhuba.core.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pinhuba.common.pack.HrmEmployeePack;
import com.pinhuba.common.pages.Pager;
import com.pinhuba.common.util.EnumUtil;
import com.pinhuba.core.dao.IHrmDepartmentDao;
import com.pinhuba.core.dao.IHrmEmployeeDao;
import com.pinhuba.core.dao.IHrmPostDao;
import com.pinhuba.core.dao.ISysUserInfoDao;
import com.pinhuba.core.iservice.IHrmEmployeeService;
import com.pinhuba.core.pojo.HrmDepartment;
import com.pinhuba.core.pojo.HrmEmployee;
import com.pinhuba.core.pojo.HrmPost;
import com.pinhuba.core.pojo.SysUserInfo;

/**********************************************
Class name: 人力资源
Description:对Sevice服务进行描述
Others:         // 
History:
**********************************************/
@Service
public class HrmEmployeeService implements IHrmEmployeeService {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IHrmEmployeeDao hrmEmployeeDao;
	@Resource
	private IHrmDepartmentDao hrmDepartmentDao;
	@Resource
	private IHrmPostDao hrmPostDao;
	@Resource
	private ISysUserInfoDao sysUserInfoDao;
	
	public int listEmployeeByGroupIdCount(HrmEmployee employee){
		int count = hrmEmployeeDao.findBySqlCount(HrmEmployeePack.packEmployeeQueryByGroupId(employee));
		return count;
	}

	public List<HrmEmployee> listEmployeeByGroupId(HrmEmployee employee, Pager pager){
		List<HrmEmployee> list = hrmEmployeeDao.findBySqlPage(HrmEmployeePack.packEmployeeQueryByGroupId(employee), HrmEmployee.class, pager);
		return list;
	}
	
	
	/**
	 * 获取所有人员信息
	 */
	public List<HrmEmployee> getAllEmployee(HrmEmployee employee, Pager pager) {
		List<HrmEmployee> employeeList = hrmEmployeeDao.findByHqlWherePage(HrmEmployeePack.packEmployeeQuery(employee)+" order by model.hrmEmployeeCode", pager);

		return employeeList;
	}

	/**
	 *  获取所有人员信息 不分页
	 */
	public List<HrmEmployee> getAllEmployeeNoPager(HrmEmployee employee){
		List<HrmEmployee> employeeList = hrmEmployeeDao.findByHqlWhere(HrmEmployeePack.packEmployeeQuery(employee)+" order by model.hrmEmployeeCode");
		return employeeList;
	}
	/**
	 * 统计人员记录数量
	 */
	public int listEmployeeCount(HrmEmployee employee) {
		int count = hrmEmployeeDao.findByHqlWhereCount(HrmEmployeePack.packEmployeeQuery(employee));
		return count;
	}

	/**
	 * 根据上级部门获取部门信息
	 */
	public List<HrmDepartment> getDownDeptartByCode(String code){
		List<HrmDepartment> deptList = hrmDepartmentDao.findByHqlWhere(" and model.hrmDepUpid = '"+code+"' order by model.hrmDepShowRow");
		return deptList;
	}
	/**
	 * 根据编码查询自己及下级
	 */
	public List<HrmDepartment> getHrmDepartmetnListByDepId(String code){
		List<HrmDepartment> deptList = hrmDepartmentDao.findByHqlWhere(" and model.hrmDepId like '"+code+"%'");
		return deptList;
	}
	
	/**
	 * 根据编码查询自己及下级
	 */
	public List<HrmPost> getHrmPostListByPostId(String code){
		List<HrmPost> postList = hrmPostDao.findByHqlWhere(" and model.hrmPostId like '"+code+"%'");
		return postList;
	}
	
	/**
	 * 更新部门编码
	 */	
	public void updateBatchHrmDepartmentIdAndUpId(String oldId,String newId){
		
		log.info("编码："+oldId+"更换为"+newId+"....");
		
		List<HrmDepartment> deptList = hrmDepartmentDao.findByHqlWhere(" and model.hrmDepId like '"+oldId+"%' and model.hrmDepId<>'"+oldId+"'");
		int oldIdLen = oldId.length();
		for (HrmDepartment hrmDepartment : deptList) {
			String tmp = hrmDepartment.getHrmDepId();
			String uptmp = hrmDepartment.getHrmDepUpid();
			String depCode =  newId+tmp.substring(oldIdLen,tmp.length());
			String depUpCode = newId+uptmp.substring(oldIdLen,uptmp.length());
			hrmDepartment.setHrmDepId(depCode);
			hrmDepartment.setHrmDepUpid(depUpCode);
			hrmDepartmentDao.save(hrmDepartment);
			log.info(tmp+"更换为"+depCode+"....");
		}
	}
	
	/**
	 * 更新岗位编码
	 */	
	public void updateBatchHrmPostIdAndUpId(String oldId,String newId){
		
		log.info("岗位编码："+oldId+"更换为"+newId+"....");
		
		List<HrmPost> postList = hrmPostDao.findByHqlWhere(" and model.hrmPostId like '"+oldId+"%' and model.hrmPostId<>'"+oldId+"'");
		int oldIdLen = oldId.length();
		for (HrmPost hrmpost : postList) {
			String tmp = hrmpost.getHrmPostId();
			String uptmp = hrmpost.getHrmPostUpid();
			String depCode =  newId+tmp.substring(oldIdLen,tmp.length());
			String depUpCode = newId+uptmp.substring(oldIdLen,uptmp.length());
			hrmpost.setHrmPostId(depCode);
			hrmpost.setHrmPostUpid(depUpCode);
			hrmPostDao.save(hrmpost);
			log.info(tmp+"更换为"+depCode+"....");
		}
	}
	
	/**
	 * 根据上级部门节点统计部门数量
	 */
	public int getDownDeptartByCodeCount(String code){
		int count = hrmDepartmentDao.findByHqlWhereCount(" and model.hrmDepUpid = '"+code+"'");
		return count;
	}

    /**
     * 根据id获取部门信息
     */
	public HrmDepartment getDepartmentByID(Integer hrmEmployeeDepid) {
		HrmDepartment hdp = hrmDepartmentDao.getByPK((long)hrmEmployeeDepid);
		return hdp;
	}

	/**
	 * 保存人员信息
	 */
	public HrmEmployee saveEmployee(HrmEmployee employee) {
		HrmEmployee employeeTemp = (HrmEmployee) hrmEmployeeDao.save(employee);
		return employeeTemp;
	}
	
	/**
	 * 根据主键获取人员信息
	 */
    public HrmEmployee getEmployeeByPK(String employeePK) {
		HrmEmployee employee = hrmEmployeeDao.getByPK(employeePK);
		return employee;
	}
    
    /**根据名字获取相应的信息
     * 
     */
    public List<HrmEmployee> getEmployeeByName(String empname){
    	List<HrmEmployee> list  = hrmEmployeeDao.findByHqlWhere(" and model.hrmEmployeeName = '" + empname + "'");
    	return list;
    }

    /**
     * 根据主键s获取人员信息
     */
    public List<HrmEmployee> getEmployeeByPKs(String employeePKs){
    	List<HrmEmployee> list = new ArrayList<HrmEmployee>();
    	if(employeePKs == null || employeePKs.length() == 0){
    		return list;
    	}else{
			String[] employeePKArray = employeePKs.substring(0, employeePKs.length()-1).split(",");
			employeePKs = "";
			for (int i = 0 ; i < employeePKArray.length ;i++) {
				if(i ==  employeePKArray.length -1){
					employeePKs += "'" + employeePKArray[i] + "'";
				}else{
					employeePKs += "'" + employeePKArray[i] + "',";
				}
			}
	    	list = hrmEmployeeDao.findByHqlWhere(" and model.primaryKey in ( " + employeePKs + " ) ");
	    	return list;
    	}
    }
    
    /**
     * 根据多条主键获取部门信息
     */
    public List<HrmDepartment> getDepartmentByPKs(String ids){
    	List<HrmDepartment> list = new ArrayList<HrmDepartment>();
    	if(ids == null || ids.length() == 0){
    		return list;
    	}else{
			ids = ids.substring(0,ids.length()-1);
	    	list = hrmDepartmentDao.findByHqlWhere(" and model.primaryKey in ( " +ids + " ) ");
	    	return list;
    	}
    }
    
    
    /**
     * 获取所有部门信息
     */
	public List<HrmDepartment> getAllDepartment(HrmDepartment department, Pager pager) {
		String tmproder = "model.hrmDepCode";
		if (department.getHrmDepUpid()!=null&&department.getHrmDepUpid().length()>0) {
			tmproder = "model.hrmDepShowRow";
		}
		
		
		List<HrmDepartment> hrmDepartment = hrmDepartmentDao.findByHqlWherePage(HrmEmployeePack.packDepartmentQuery(department)+" order by "+tmproder, pager);
		for (HrmDepartment dep : hrmDepartment) {
			
			List<HrmDepartment> parentDepartment = null;
			// 如果有上级单位
			if ( dep.getHrmDepUpid() != null && !"00".equals(dep.getHrmDepUpid()) ) {
				 parentDepartment =  hrmDepartmentDao.findByHqlWhere(" and model.hrmDepId = '" + dep.getHrmDepUpid() + "'");
			     if(parentDepartment.size() > 0){
			    	 for(HrmDepartment kk :parentDepartment){
			    		 dep.setParentDepartment(kk);
			    	 }
			     }
			}else{ // 如果上级单位为顶级或查找不到
				dep.setHrmDepUpid(null);
			}
            //转换部门经理
			if(dep.getHrmEmpId() != null){
				HrmEmployee manager = hrmEmployeeDao.getByPK(dep.getHrmEmpId());
				dep.setEmployee(manager);
			}
			
		}
		return hrmDepartment;
	}

	/**
	 * 统计部门数量
	 */
	public int listDepartmentCount(HrmDepartment department) {
		int count = hrmDepartmentDao.findByHqlWhereCount(HrmEmployeePack.packDepartmentQuery(department));
		return count;
	}
	
	/**
	 * 根据主键获取部门信息
	 */
    public HrmDepartment getDepartmentByPK(long id){
    	HrmDepartment department = hrmDepartmentDao.getByPK(id);
    	return department;
    }
    
    /**
     * 保存部门信息
     */
    public HrmDepartment saveDepartment(HrmDepartment department){
		HrmDepartment tmp = (HrmDepartment) hrmDepartmentDao.save(department);
    	return tmp;
    }

    /**
     * 删除部门信息
     */
	public void deleteDepartmentById(long[] ids) {
		for (long l : ids) {
			HrmDepartment department = hrmDepartmentDao.getByPK(l);
			hrmDepartmentDao.remove(department);
		}
	}
	
	/**
	 * 根据上级节点统计部门数量
	 */
	public int getdepartmentByUpCode(String upcode){
		int row = hrmDepartmentDao.findByHqlWhereCount(" and model.hrmDepUpid ='"+upcode+"'");
		return row;
	}

	/**
	 * 根据部门节点获取部门信息。
	 */
	public HrmDepartment getDepartmentByCode(String code) {
		List<HrmDepartment> department  = hrmDepartmentDao.findByHqlWhere(" and model.hrmDepId = '" + code + "'");
		HrmDepartment dep =null;
    	if (department.size()>0) {
			dep = department.get(0);
		}
    	return dep;
	}

	/**
	 * 分页显示所有岗位
	 */
	public List<HrmPost> getAllPost(HrmPost hrmPost, Pager pager) {
		String tmproder = "model.hrmPostId";
		if (hrmPost.getHrmPostUpid()!=null&&hrmPost.getHrmPostUpid().length()>0) {
			tmproder = "model.hrmPostShowRow";
		}

		List<HrmPost> postList = hrmPostDao.findByHqlWherePage(HrmEmployeePack.packPostQuery(hrmPost)+" order by "+tmproder, pager);
		for (HrmPost post : postList) {
			if (post.getHrmPostUpid()!=null&&post.getHrmPostUpid().length()>0) {
				List<HrmPost> tmplist = hrmPostDao.findByHqlWhere(" and model.hrmPostId='"+post.getHrmPostUpid()+"'");
				if (tmplist.size()>0) {
					post.setHrmUpPost(tmplist.get(0));	
				}
			}
			if (post.getHrmPostMang()!=null&&post.getHrmPostMang().length()>0) {
				post.setMangerEmployee(hrmEmployeeDao.getByPK(post.getHrmPostMang()));
			}
			
		}
		return postList;
	}

	/**
	 * 统计岗位个数
	 */
	public int listPostCount(HrmPost hrmPost) {
		int count = hrmPostDao.findByHqlWhereCount(HrmEmployeePack.packPostQuery(hrmPost));
		return count;
	}

	/**
	 * 设置离职状态，人员信息置于无效状态，如果存在用户的话，则设置其用户为无效状态
	 */
	public void setSeparationByPks(String[] employeePKs) {
         for(String l : employeePKs){
             List<SysUserInfo>  userList = sysUserInfoDao.findByHqlWhere(" and model.hrmEmployeeId='"+l+"'");
             if(userList.isEmpty() == false){
            	 SysUserInfo  userInfo = userList.get(0);
            	 userInfo.setUserAction(EnumUtil.SYS_ISACTION.No_Vaild.value);
            	 sysUserInfoDao.save(userInfo);
             }
             HrmEmployee employee = hrmEmployeeDao.getByPK(l);
             employee.setHrmEmployeeStatus(EnumUtil.HRM_EMPLOYEE_STATUS.Separation.value);
             employee.setHrmEmployeeActive(EnumUtil.SYS_ISACTION.No_Vaild.value);
             
             hrmEmployeeDao.save(employee);
         }
	}

	/**
	 * 保存岗位
	 */
	public HrmPost savePost(HrmPost post) {
		HrmPost posttemp =  (HrmPost) hrmPostDao.save(post);
		return posttemp;
	}

	/**
	 * 根据岗位主键获取岗位
	 */
	public HrmPost getPostByPk(long postPk) {
		HrmPost post = hrmPostDao.getByPK(postPk);
		
		if ((post.getHrmPostUpid()!= null && post.getHrmPostUpid().length()>0) || post.getHrmPostUpid() != "00") {
			List<HrmPost> tmplist = hrmPostDao.findByHqlWhere(" and model.hrmPostId='"+post.getHrmPostUpid()+"'");
			if (tmplist.size()>0) {
				post.setHrmUpPost(tmplist.get(0));
			}
		}
		if (post.getHrmPostMang()!=null&&post.getHrmPostMang().length()>0) {
			post.setMangerEmployee(hrmEmployeeDao.getByPK(post.getHrmPostMang()));
		}
		return post;
	}

	/**
	 *   删除岗位信息
	 */
	public void deletePostsByPks(long[] postPks) {
		for (long l : postPks) {
			HrmPost post = hrmPostDao.getByPK(l);
			hrmPostDao.remove(post);
		}
	}
	
	/**
	 * 根据上级岗位查询岗位信息
	 */
	public List<HrmPost> getHrmPostListByUpcode(String upcode){
		List<HrmPost> postList = hrmPostDao.findByHqlWhere(" and model.hrmPostUpid='"+upcode+"' order by model.hrmPostShowRow");
		return postList;
	}
	
	/**
	 * 根据上级岗位统计岗位数量
	 */
	public int getHrmPostByUpcodeCount(String upcode){
		return hrmPostDao.findByHqlWhereCount(" and model.hrmPostUpid='"+upcode+"'");
	}
	
	/**
	 * 检测岗位下是否包含人员
	 * @param postid
	 * @return
	 */
	public int getEmployeeCountByPostId(long postid){
		int row = hrmEmployeeDao.findByHqlWhereCount(" and model.hrmEmployeePostId="+postid);
		int tmprow=0;
		if (row>0) {
			return row;
		}else{
			List<Object[]> objlist = hrmEmployeeDao.findBySqlObjList("select hrm_part_post from hrm_employee where length(hrm_part_post)>0");
			for (Object[] obj : objlist) {
				if(obj!=null&&obj[0]!=null){
					String[] tmp = ((String) obj[0]).split(",");
					for (String str : tmp) {
						if (str!=null&&str.length()>0&&Long.parseLong(str)==postid) {
							tmprow++;
							break;
						}
					}
				}
				if (tmprow>0) {
					break;
				}
			}
		}
		return tmprow;
	}
	
	/**
	 * 统计主岗位为指定的人员信息数量
	 */
	public int getEmployeeCountByMainPostId(long postid){
		int row = hrmEmployeeDao.findByHqlWhereCount(" and model.hrmEmployeePostId="+postid);
		return row;
	}
	
	/**
	 * 获取主岗位为指定的人员信息
	 */
	public List<HrmEmployee> getEmployeeeByMainPostId(long postid, Pager pager){
		List<HrmEmployee> employeelist= hrmEmployeeDao.findByHqlWherePage(" and model.hrmEmployeePostId="+postid, pager);
		return employeelist;
	}

    /**
     * 根据主键ID获取岗位信息
     */
	public HrmPost getPostByPkUseEmp(long hrmEmployeePostId) {
		HrmPost post = hrmPostDao.getByPK(hrmEmployeePostId);
		return post;
	}

	/**
	 * 根据人员姓名查询人员，返回TRUE，或 FALSE
	 */
	public boolean checkEmployeeByEmployeeName(HrmEmployee employee) {

		String sql = " and model.hrmEmployeeName='"+employee.getHrmEmployeeName()+"' and model.hrmEmployeeActive="+EnumUtil.SYS_ISACTION.Vaild.value;
		if (employee.getPrimaryKey()!=null&&employee.getPrimaryKey().trim().length()>0) {
			sql+=" and model.primaryKey <> '"+employee.getPrimaryKey()+"'";
		}
		int count= hrmEmployeeDao.findByHqlWhereCount(sql);

		if(count>0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 查询员工编码为指定的人员 返回TRUE，FALSE
	 */
	public boolean checkEmployeeByEmployeeCardid(HrmEmployee employee) {
		String sql = " and model.hrmEmployeeCode='"+employee.getHrmEmployeeCode()+"' and model.hrmEmployeeActive="+EnumUtil.SYS_ISACTION.Vaild.value;
		if (employee.getPrimaryKey()!=null&&employee.getPrimaryKey().trim().length()>0) {
			sql+=" and model.primaryKey <> '"+employee.getPrimaryKey()+"'";
		}
		int count= hrmEmployeeDao.findByHqlWhereCount(sql);

		if(count>0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 获取人员所有岗位
	 */
	public List<HrmEmployee> getAllEmployee_post(HrmEmployee employee,
			Pager pager) {
		List<HrmEmployee> employeelist = hrmEmployeeDao.findBySqlPage(HrmEmployeePack.getEmployeeSql(employee)+" order by emp.hrm_employee_code",HrmEmployee.class,pager);
		for (HrmEmployee hrmEmployee : employeelist) {
			//写入部门
			if(hrmEmployee.getHrmEmployeeDepid() != null && hrmEmployee.getHrmEmployeeDepid()>0){
				hrmEmployee.setHrmDepartment(hrmDepartmentDao.getByPK((long)hrmEmployee.getHrmEmployeeDepid()));	
			}
			//写入主岗位
			if(hrmEmployee.getHrmEmployeePostId() != null && hrmEmployee.getHrmEmployeePostId()>0){
				hrmEmployee.setHrmEmployeePost(hrmPostDao.getByPK((long)hrmEmployee.getHrmEmployeePostId()));
			}
			
			//写入兼职岗位
			if(hrmEmployee.getHrmPartPost() != null && hrmEmployee.getHrmPartPost().length()>0){
				String hrmPartPostNames = "";
				String pids = hrmEmployee.getHrmPartPost();
				if (pids.charAt(pids.length() - 1) == ',') {
					pids = pids.substring(0, pids.length() - 1);
				}
				List<HrmPost> postlist = hrmPostDao.findByHqlWhere(" and model.primaryKey in ( "+pids+" )");
				for (int i = 0; i < postlist.size(); i++) {
					HrmPost hrmPost = postlist.get(i);
					if (hrmPost.getHrmPostName()!=null&&hrmPost.getHrmPostName().length()>0) {
						if (i== postlist.size()-1) {
							hrmPartPostNames+=hrmPost.getHrmPostName();
						}else{
							hrmPartPostNames+=hrmPost.getHrmPostName()+",";
						}
					}
				}
				hrmEmployee.setHrmPartPostName(hrmPartPostNames);
			}
			
		}
		
		return employeelist;
	}

    /**
     * 统计人员岗位数量
     */
	public int listEmployeeCount_post(HrmEmployee employee) {
		return hrmEmployeeDao.findBySqlCount(HrmEmployeePack.getEmployeeSql(employee));
	}

	/**
	 * 批量设置人员岗位
	 */
	public List<HrmEmployee> getAllEmployee_post_set(String employeepks,
			Pager pager) {
		List<HrmEmployee> employeeList = null;
		String[] empids = employeepks.split(",");
		String empid = "";
		for (String str : empids) {
			if (str != null && str.length() > 0) {
				empid += "'"+str+"'"+",";
			}
		}
		if (empid.length() > 0) {
			empid = empid.substring(0, empid.length() - 1);
		
		   employeeList = hrmEmployeeDao.findBySqlPage("select * from hrm_employee where hrm_employee_id in ( " + empid + " )",HrmEmployee.class, pager);
		}
		
		for (HrmEmployee hrmEmployee : employeeList) {
			//写入部门
			if(hrmEmployee.getHrmEmployeeDepid() != null && hrmEmployee.getHrmEmployeeDepid()>0){
				hrmEmployee.setHrmDepartment(hrmDepartmentDao.getByPK((long)hrmEmployee.getHrmEmployeeDepid()));	
			}
			//写入主岗位
			if(hrmEmployee.getHrmEmployeePostId() != null && hrmEmployee.getHrmEmployeePostId()>0){
				hrmEmployee.setHrmEmployeePost(hrmPostDao.getByPK((long)hrmEmployee.getHrmEmployeePostId()));
			}
			
			//写入兼职岗位
			if(hrmEmployee.getHrmPartPost() != null && hrmEmployee.getHrmPartPost().length()>0){
				String hrmPartPostNames = "";
				String pids = hrmEmployee.getHrmPartPost();
				if (pids.charAt(pids.length() - 1) == ',') {
					pids = pids.substring(0, pids.length() - 1);
				}
				List<HrmPost> postlist = hrmPostDao.findByHqlWhere(" and model.primaryKey in ( "+pids+" )");
				for (int i = 0; i < postlist.size(); i++) {
					HrmPost hrmPost = postlist.get(i);
					if (hrmPost.getHrmPostName()!=null&&hrmPost.getHrmPostName().length()>0) {
						if (i== postlist.size()-1) {
							hrmPartPostNames+=hrmPost.getHrmPostName();
						}else{
							hrmPartPostNames+=hrmPost.getHrmPostName()+",";
						}
					}
				}
				hrmEmployee.setHrmPartPostName(hrmPartPostNames);
			}
			
		}
		return employeeList;
	}

	/**
	 * 根据人员主键统计人员岗位数
	 */
	public int listEmployeeCount_post_set(String employeepks) {
		String[] empids = employeepks.split(",");
		return empids.length;
	}

	/**
	 * 设置人员主岗位和兼职岗位
	 */
	public void setEmployeePostAndPartPost(String employeepks, String postid,
			String partpost) {
		String[] empids = employeepks.split(",");
		for (int i = 0; i < empids.length; i++) {
			HrmEmployee employee = hrmEmployeeDao.getByPK(empids[i]);
			int pid = Integer.parseInt("".equals(postid)?"0":postid);
			employee.setHrmEmployeePostId(pid);
			employee.setHrmPartPost(partpost);
			
			hrmEmployeeDao.save(employee);
			
			//检测人员是否为岗位负责人和调整后的主岗位
			List<HrmPost> postlist= hrmPostDao.findByHqlWhere(" and model.hrmPostMang ='"+empids[i]+"'");
			for (HrmPost hrmPost : postlist) {
				if ((int)hrmPost.getPrimaryKey()!=pid) {
					hrmPost.setHrmPostMang("");
					hrmPostDao.save(hrmPost);
				}
			}
		}
		
	}

	/**
	 * 不分页查询部门信息
	 */
	public List<HrmDepartment> getAllDepNopager() {
		List<HrmDepartment> list = hrmDepartmentDao.list();
		return list;
	}

	/**
	 * 判断同一级别下重名部门
	 * @param name
	 * @param code
	 * @param com
	 * @return
	 */
	public int getDepartmentCountBynameAndCode(String name,String code, long id){
		int count = 0;
		if(id>0){
			count = hrmDepartmentDao.findByHqlWhereCount(" and model.hrmDepName='"+name+"' and model.hrmDepUpid='"+code+"' and model.primaryKey<>"+id);
		}else{
			count = hrmDepartmentDao.findByHqlWhereCount(" and model.hrmDepName='"+name+"' and model.hrmDepUpid='"+code+"'");
		}
		return count;
	}
}
