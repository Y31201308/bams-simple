package com.pinhuba.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.dao.*;
/**
 * 表：HM_PROJECT_BUILDING 对应daoImpl
 */
@Repository
public class HmProjectBuildingDaoImpl extends BaseHapiDaoimpl<HmProjectBuilding, String> implements IHmProjectBuildingDao {

    public HmProjectBuildingDaoImpl(){
        super(HmProjectBuilding.class);
    }
}