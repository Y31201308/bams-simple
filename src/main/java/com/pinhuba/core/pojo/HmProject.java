package com.pinhuba.core.pojo;

import com.pinhuba.common.annotation.Remark;

/**
 * 数据库表名：HM_PROJECT
 */
public class HmProject extends BaseStringBean implements java.io.Serializable {

    private String code;
    private String upcode;
    private String projectName;
    private String projectCode;
    private String projectSimple;
    private String projectAddr;
    private String plotsName;
    private String spreadName;
    private String managerId;
    private String startDate;
    private String endDate;
    private String openDate;
    private String closeDate;
    private Integer status;
    private String projectDesc;
    private Integer projectArea;
    private Integer buildArea;
    private Integer houseArea;
    private Integer saleArea;
    private Integer companyId;
    private Integer priority;
    private String landCertificateCode;
    private String landCertificateDate;
    private String projectplanPermitCode;
    private String projectplanPermitDate;
    private String landplanPermitCode;
    private String landplanPermitDate;
    private String constructionPermitCode;
    private String constructionPermitDate;
    private String persalePermitCode;
    private String persalePermitDate;

    //默认构造方法
    public HmProject(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
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

    public String getProjectName(){
        return projectName;
    }

    public void setProjectName(String aProjectName){
        this.projectName = aProjectName;
    }

    public String getProjectCode(){
        return projectCode;
    }

    public void setProjectCode(String aProjectCode){
        this.projectCode = aProjectCode;
    }

    public String getProjectSimple(){
        return projectSimple;
    }

    public void setProjectSimple(String aProjectSimple){
        this.projectSimple = aProjectSimple;
    }

    public String getProjectAddr(){
        return projectAddr;
    }

    public void setProjectAddr(String aProjectAddr){
        this.projectAddr = aProjectAddr;
    }

    public String getPlotsName(){
        return plotsName;
    }

    public void setPlotsName(String aPlotsName){
        this.plotsName = aPlotsName;
    }

    public String getSpreadName(){
        return spreadName;
    }

    public void setSpreadName(String aSpreadName){
        this.spreadName = aSpreadName;
    }

    public String getManagerId(){
        return managerId;
    }

    public void setManagerId(String aManagerId){
        this.managerId = aManagerId;
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

    public String getOpenDate(){
        return openDate;
    }

    public void setOpenDate(String aOpenDate){
        this.openDate = aOpenDate;
    }

    public String getCloseDate(){
        return closeDate;
    }

    public void setCloseDate(String aCloseDate){
        this.closeDate = aCloseDate;
    }

    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer aStatus){
        this.status = aStatus;
    }

    public String getProjectDesc(){
        return projectDesc;
    }

    public void setProjectDesc(String aProjectDesc){
        this.projectDesc = aProjectDesc;
    }

    public Integer getProjectArea(){
        return projectArea;
    }

    public void setProjectArea(Integer aProjectArea){
        this.projectArea = aProjectArea;
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

    public Integer getPriority(){
        return priority;
    }

    public void setPriority(Integer aPriority){
        this.priority = aPriority;
    }

    public String getLandCertificateCode(){
        return landCertificateCode;
    }

    public void setLandCertificateCode(String aLandCertificateCode){
        this.landCertificateCode = aLandCertificateCode;
    }

    public String getLandCertificateDate(){
        return landCertificateDate;
    }

    public void setLandCertificateDate(String aLandCertificateDate){
        this.landCertificateDate = aLandCertificateDate;
    }

    public String getProjectplanPermitCode(){
        return projectplanPermitCode;
    }

    public void setProjectplanPermitCode(String aProjectplanPermitCode){
        this.projectplanPermitCode = aProjectplanPermitCode;
    }

    public String getProjectplanPermitDate(){
        return projectplanPermitDate;
    }

    public void setProjectplanPermitDate(String aProjectplanPermitDate){
        this.projectplanPermitDate = aProjectplanPermitDate;
    }

    public String getLandplanPermitCode(){
        return landplanPermitCode;
    }

    public void setLandplanPermitCode(String aLandplanPermitCode){
        this.landplanPermitCode = aLandplanPermitCode;
    }

    public String getLandplanPermitDate(){
        return landplanPermitDate;
    }

    public void setLandplanPermitDate(String aLandplanPermitDate){
        this.landplanPermitDate = aLandplanPermitDate;
    }

    public String getConstructionPermitCode(){
        return constructionPermitCode;
    }

    public void setConstructionPermitCode(String aConstructionPermitCode){
        this.constructionPermitCode = aConstructionPermitCode;
    }

    public String getConstructionPermitDate(){
        return constructionPermitDate;
    }

    public void setConstructionPermitDate(String aConstructionPermitDate){
        this.constructionPermitDate = aConstructionPermitDate;
    }

    public String getPersalePermitCode(){
        return persalePermitCode;
    }

    public void setPersalePermitCode(String aPersalePermitCode){
        this.persalePermitCode = aPersalePermitCode;
    }

    public String getPersalePermitDate(){
        return persalePermitDate;
    }

    public void setPersalePermitDate(String aPersalePermitDate){
        this.persalePermitDate = aPersalePermitDate;
    }

}