package com.pinhuba.core.iservice;

import java.util.List;

import com.pinhuba.core.pojo.HrmDepartment;
import com.pinhuba.core.pojo.HrmEmployee;
import com.pinhuba.core.pojo.HrmPost;
import com.pinhuba.common.pages.Pager;

/**
 * 人员相关
 * 
 * @author frin
 * 
 */
public interface IHrmEmployeeService {
	
	public int listEmployeeByGroupIdCount(HrmEmployee employee);

	public List<HrmEmployee> listEmployeeByGroupId(HrmEmployee employee, Pager pager);
	
	// 查找人员信息
	public List<HrmEmployee> getAllEmployee(HrmEmployee employee, Pager pager);
	
	public List<HrmEmployee> getAllEmployeeNoPager(HrmEmployee employee);
	
	public void updateBatchHrmDepartmentIdAndUpId(String oldId, String newId);
	
	public List<HrmPost> getHrmPostListByPostId(String code);
	
	public void updateBatchHrmPostIdAndUpId(String oldId,String newId);
	
	public List<HrmDepartment> getHrmDepartmetnListByDepId(String code);

	public int listEmployeeCount(HrmEmployee employee);

	public List<HrmDepartment> getDownDeptartByCode(String code);

	public int getDownDeptartByCodeCount(String code);

	public HrmDepartment getDepartmentByID(Integer hrmEmployeeDepid);

	public HrmEmployee saveEmployee(HrmEmployee employee);

	public HrmEmployee getEmployeeByPK(String employeePK);
	
	public List<HrmEmployee> getEmployeeByName(String empname);

	public List<HrmEmployee> getEmployeeByPKs(String employeePKs);
	
	public List<HrmDepartment> getDepartmentByPKs(String ids);
	
	// 分页显示所有部门
	public List<HrmDepartment> getAllDepartment(HrmDepartment department, Pager pager);

	// 不分页获取部门
	public List<HrmDepartment> getAllDepNopager();

	// 获取部门数
	public int listDepartmentCount(HrmDepartment department);

	public HrmDepartment getDepartmentByPK(long id);

	public HrmDepartment saveDepartment(HrmDepartment department);

	public void deleteDepartmentById(long[] ids);

	// 根据部门编号获取
	public HrmDepartment getDepartmentByCode(String code);

	public int listPostCount(HrmPost hrmPost);

	public List<HrmPost> getAllPost(HrmPost hrmPost, Pager pager);

	public void setSeparationByPks(String[] employeePKs);

	public HrmPost savePost(HrmPost post);

	public int getdepartmentByUpCode(String upcode);

	public HrmPost getPostByPk(long postPk);

	public void deletePostsByPks(long[] postPks);

	public List<HrmPost> getHrmPostListByUpcode(String upcode);

	public int getHrmPostByUpcodeCount(String upcode);

	public int getEmployeeCountByPostId(long postid);

	public List<HrmEmployee> getEmployeeeByMainPostId(long postid, Pager pager);

	public int getEmployeeCountByMainPostId(long postid);

	public HrmPost getPostByPkUseEmp(long hrmEmployeePostId);

	public boolean checkEmployeeByEmployeeName(HrmEmployee employee);

	public boolean checkEmployeeByEmployeeCardid(HrmEmployee employee);

	public int listEmployeeCount_post(HrmEmployee employee);

	public List<HrmEmployee> getAllEmployee_post(HrmEmployee employee, Pager pager);

	public int listEmployeeCount_post_set(String employeepks);

	public List<HrmEmployee> getAllEmployee_post_set(String employeepks, Pager pager);

	public void setEmployeePostAndPartPost(String employeepks, String postid, String partpost);
	
	public int getDepartmentCountBynameAndCode(String name, String code, long id);
}
