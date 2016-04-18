package com.pinhuba.core.pojo;

import com.pinhuba.common.annotation.Remark;

/**
 * 数据库表名：HM_PROJECT_STANDARD
 */
public class HmProjectStandard extends BaseStringBean implements java.io.Serializable {

    private String standardName;
    private String projectId;
    private Integer unitPrice;
    private String remark;
    private Integer companyId;

    //默认构造方法
    public HmProjectStandard(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getStandardName(){
        return standardName;
    }

    public void setStandardName(String aStandardName){
        this.standardName = aStandardName;
    }

    public String getProjectId(){
        return projectId;
    }

    public void setProjectId(String aProjectId){
        this.projectId = aProjectId;
    }

    public Integer getUnitPrice(){
        return unitPrice;
    }

    public void setUnitPrice(Integer aUnitPrice){
        this.unitPrice = aUnitPrice;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String aRemark){
        this.remark = aRemark;
    }

    public Integer getCompanyId(){
        return companyId;
    }

    public void setCompanyId(Integer aCompanyId){
        this.companyId = aCompanyId;
    }

}