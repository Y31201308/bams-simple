package com.pinhuba.core.pojo;

import com.pinhuba.common.annotation.Remark;

/**
 * 数据库表名：HM_HOUSE_INFO
 */
public class HmHouseInfo extends BaseStringBean implements java.io.Serializable {

    private String projectId;
    private String regionId;
    private String buildingId;
    private Integer houseType;
    private String houseCode;
    private String houseName;
    private String floor;
    private String unit;
    private String houseSn;
    private Integer saleStatus;
    private String contractCode;
    private Integer houseDirection;
    private Integer houseStructure;
    private Integer houseStyle;
    private String houseLift;
    private Integer buildingArea;
    private Integer houseArea;
    private Integer saleArea;
    private Integer companyId;

    //默认构造方法
    public HmHouseInfo(){
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

    public String getBuildingId(){
        return buildingId;
    }

    public void setBuildingId(String aBuildingId){
        this.buildingId = aBuildingId;
    }

    public Integer getHouseType(){
        return houseType;
    }

    public void setHouseType(Integer aHouseType){
        this.houseType = aHouseType;
    }

    public String getHouseCode(){
        return houseCode;
    }

    public void setHouseCode(String aHouseCode){
        this.houseCode = aHouseCode;
    }

    public String getHouseName(){
        return houseName;
    }

    public void setHouseName(String aHouseName){
        this.houseName = aHouseName;
    }

    public String getFloor(){
        return floor;
    }

    public void setFloor(String aFloor){
        this.floor = aFloor;
    }

    public String getUnit(){
        return unit;
    }

    public void setUnit(String aUnit){
        this.unit = aUnit;
    }

    public String getHouseSn(){
        return houseSn;
    }

    public void setHouseSn(String aHouseSn){
        this.houseSn = aHouseSn;
    }

    public Integer getSaleStatus(){
        return saleStatus;
    }

    public void setSaleStatus(Integer aSaleStatus){
        this.saleStatus = aSaleStatus;
    }

    public String getContractCode(){
        return contractCode;
    }

    public void setContractCode(String aContractCode){
        this.contractCode = aContractCode;
    }

    public Integer getHouseDirection(){
        return houseDirection;
    }

    public void setHouseDirection(Integer aHouseDirection){
        this.houseDirection = aHouseDirection;
    }

    public Integer getHouseStructure(){
        return houseStructure;
    }

    public void setHouseStructure(Integer aHouseStructure){
        this.houseStructure = aHouseStructure;
    }

    public Integer getHouseStyle(){
        return houseStyle;
    }

    public void setHouseStyle(Integer aHouseStyle){
        this.houseStyle = aHouseStyle;
    }

    public String getHouseLift(){
        return houseLift;
    }

    public void setHouseLift(String aHouseLift){
        this.houseLift = aHouseLift;
    }

    public Integer getBuildingArea(){
        return buildingArea;
    }

    public void setBuildingArea(Integer aBuildingArea){
        this.buildingArea = aBuildingArea;
    }

    public Integer getHouseArea(){
        return houseArea;
    }

    public void setHouseArea(Integer aHouseArea){
        this.houseArea = aHouseArea;
    }

    public Integer getSaleArea(){
        return saleArea;
    }

    public void setSaleArea(Integer aSaleArea){
        this.saleArea = aSaleArea;
    }

    public Integer getCompanyId(){
        return companyId;
    }

    public void setCompanyId(Integer aCompanyId){
        this.companyId = aCompanyId;
    }

}