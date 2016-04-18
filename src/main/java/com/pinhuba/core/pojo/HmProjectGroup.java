package com.pinhuba.core.pojo;

import com.pinhuba.common.annotation.Remark;

/**
 * 数据库表名：HM_PROJECT_GROUP
 */
public class HmProjectGroup extends BaseStringBean implements java.io.Serializable {

    private String projectId;
    private String code;
    private String upcode;
    private String name;
    private Integer priority;
    private Integer companyId;

    //默认构造方法
    public HmProjectGroup(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getProjectId(){
        return projectId;
    }

    public void setProjectId(String aProjectId){
        this.projectId = aProjectId;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String aCode){
        this.code = aCode;
    }

    public String getUpcode(){
        return upcode;
    }

    public void setUpcode(String aUpcode){
        this.upcode = aUpcode;
    }

    public String getName(){
        return name;
    }

    public void setName(String aName){
        this.name = aName;
    }

    public Integer getPriority(){
        return priority;
    }

    public void setPriority(Integer aPriority){
        this.priority = aPriority;
    }

    public Integer getCompanyId(){
        return companyId;
    }

    public void setCompanyId(Integer aCompanyId){
        this.companyId = aCompanyId;
    }

}