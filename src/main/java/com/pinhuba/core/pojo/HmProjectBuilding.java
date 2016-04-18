package com.pinhuba.core.pojo;

import com.pinhuba.common.annotation.Remark;

/**
 * 数据库表名：HM_PROJECT_BUILDING
 */
public class HmProjectBuilding extends BaseStringBean implements java.io.Serializable {

    private String projectId;
    private String regionId;
    private String buildingName;
    private String buildingCode;
    private Integer buildingType;
    private Integer buildingHeight;
    private Integer floorNumber;
    private Integer floorHeight;
    private Integer houseNumber;
    private Integer buildArea;
    private Integer houseArea;
    private Integer greenArea;
    private String startDate;
    private String endDate;
    private String salePermitCode;
    private String salePermitDate;
    private Integer buildingImageId;
    private Integer planeImageId;
    private String remark;
    private Integer companyId;

    //默认构造方法
    public HmProjectBuilding(){
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

    public String getRegionId(){
        return regionId;
    }

    public void setRegionId(String aRegionId){
        this.regionId = aRegionId;
    }

    public String getBuildingName(){
        return buildingName;
    }

    public void setBuildingName(String aBuildingName){
        this.buildingName = aBuildingName;
    }

    public String getBuildingCode(){
        return buildingCode;
    }

    public void setBuildingCode(String aBuildingCode){
        this.buildingCode = aBuildingCode;
    }

    public Integer getBuildingType(){
        return buildingType;
    }

    public void setBuildingType(Integer aBuildingType){
        this.buildingType = aBuildingType;
    }

    public Integer getBuildingHeight(){
        return buildingHeight;
    }

    public void setBuildingHeight(Integer aBuildingHeight){
        this.buildingHeight = aBuildingHeight;
    }

    public Integer getFloorNumber(){
        return floorNumber;
    }

    public void setFloorNumber(Integer aFloorNumber){
        this.floorNumber = aFloorNumber;
    }

    public Integer getFloorHeight(){
        return floorHeight;
    }

    public void setFloorHeight(Integer aFloorHeight){
        this.floorHeight = aFloorHeight;
    }

    public Integer getHouseNumber(){
        return houseNumber;
    }

    public void setHouseNumber(Integer aHouseNumber){
        this.houseNumber = aHouseNumber;
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

    public String getSalePermitCode(){
        return salePermitCode;
    }

    public void setSalePermitCode(String aSalePermitCode){
        this.salePermitCode = aSalePermitCode;
    }

    public String getSalePermitDate(){
        return salePermitDate;
    }

    public void setSalePermitDate(String aSalePermitDate){
        this.salePermitDate = aSalePermitDate;
    }

    public Integer getBuildingImageId(){
        return buildingImageId;
    }

    public void setBuildingImageId(Integer aBuildingImageId){
        this.buildingImageId = aBuildingImageId;
    }

    public Integer getPlaneImageId(){
        return planeImageId;
    }

    public void setPlaneImageId(Integer aPlaneImageId){
        this.planeImageId = aPlaneImageId;
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