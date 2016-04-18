package com.pinhuba.core.pojo;

/**
 * 数据库表名：SYS_ROLE_BIND
 */
public class SysRoleBind extends BaseBean implements java.io.Serializable {

	/**
	 * 角色绑定表
	 */
	private static final long serialVersionUID = 5764094567318465684L;
	private Integer bindType; 	//对象类型
	private Integer roleId;		//角色编号
	private String bindValue;//绑定对象值

	// 默认构造方法
	public SysRoleBind() {
		super();
	}

	// get和set方法
	public Integer getBindType() {
		return bindType;
	}

	public void setBindType(Integer aBindType) {
		this.bindType = aBindType;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer aRoleId) {
		this.roleId = aRoleId;
	}
	public String getBindValue() {
		return bindValue;
	}

	public void setBindValue(String aBindValue) {
		this.bindValue = aBindValue;
	}

}