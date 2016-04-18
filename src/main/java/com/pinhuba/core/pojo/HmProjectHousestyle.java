package com.pinhuba.core.pojo;

import com.pinhuba.common.annotation.Remark;

/**
 * 数据库表名：HM_PROJECT_HOUSESTYLE
 */
public class HmProjectHousestyle extends BaseStringBean implements java.io.Serializable {

    private String projectId;
    private String styleCode;
    private Integer styleImageId;
    private Integer buildArea;
    private Integer houseArea;
    private Integer houseType;
    private Integer houseStyle;
    private Integer companyId;
    private String remark;

    //默认构造方法
    public HmProjectHousestyle(){
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

    public String getStyleCode(){
        return styleCode;
    }

    public void setStyleCode(String aStyleCode){
        this.styleCode = aStyleCode;
    }

    public Integer getStyleImageId(){
        return styleImageId;
    }

    public void setStyleImageId(Integer aStyleImageId){
        this.styleImageId = aStyleImageId;
    }

    public Integer getBuildArea(){
        return buildArea;
    }

    public void setBuildArea(Integer aBuildArea){
        this.buildArea = aBuildArea;
    }

    public Integer getHouseArea(){
        return houseArea;
    }

    public void setHouseArea(Integer aHouseArea){
        this.houseArea = aHouseArea;
    }

    public Integer getHouseType(){
        return houseType;
    }

    public void setHouseType(Integer aHouseType){
        this.houseType = aHouseType;
    }

    public Integer getHouseStyle(){
        return houseStyle;
    }

    public void setHouseStyle(Integer aHouseStyle){
        this.houseStyle = aHouseStyle;
    }

    public Integer getCompanyId(){
        return companyId;
    }

    public void setCompanyId(Integer aCompanyId){
        this.companyId = aCompanyId;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String aRemark){
        this.remark = aRemark;
    }

}