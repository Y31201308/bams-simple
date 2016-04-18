package com.pinhuba.core.pojo;

import com.pinhuba.common.annotation.Remark;

/**
 * 数据库表名：HM_PROJECT_REGION
 */
public class HmProjectRegion extends BaseStringBean implements java.io.Serializable {

    private String projectId;
    private String regionName;
    private String regionCode;
    private Integer buildArea;
    private Integer houseArea;
    private Integer greenArea;
    private String startDate;
    private String endDate;
    private String position;
    private String spreadName;
    private Integer houseNumber;
    private Integer requestPrice;
    private Integer isSale;
    private String remark;
    private Integer companyId;

    //默认构造方法
    public HmProjectRegion(){
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

    public String getRegionName(){
        return regionName;
    }

    public void setRegionName(String aRegionName){
        this.regionName = aRegionName;
    }

    public String getRegionCode(){
        return regionCode;
    }

    public void setRegionCode(String aRegionCode){
        this.regionCode = aRegionCode;
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

    public Integer getGreenArea(){
        return greenArea;
    }

    public void setGreenArea(Integer aGreenArea){
        this.greenArea = aGreenArea;
    }

    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String aStartDate){
        this.startDate = aStartDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public void setEndDate(String aEndDate){
        this.endDate = aEndDate;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String aPosition){
        this.position = aPosition;
    }

    public String getSpreadName(){
        return spreadName;
    }

    public void setSpreadName(String aSpreadName){
        this.spreadName = aSpreadName;
    }

    public Integer getHouseNumber(){
        return houseNumber;
    }

    public void setHouseNumber(Integer aHouseNumber){
        this.houseNumber = aHouseNumber;
    }

    public Integer getRequestPrice(){
        return requestPrice;
    }

    public void setRequestPrice(Integer aRequestPrice){
        this.requestPrice = aRequestPrice;
    }

    public Integer getIsSale(){
        return isSale;
    }

    public void setIsSale(Integer aIsSale){
        this.isSale = aIsSale;
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