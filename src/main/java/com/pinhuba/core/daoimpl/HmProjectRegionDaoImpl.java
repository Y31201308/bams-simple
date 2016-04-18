package com.pinhuba.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.dao.*;
/**
 * 表：HM_PROJECT_REGION 对应daoImpl
 */
@Repository
public class HmProjectRegionDaoImpl extends BaseHapiDaoimpl<HmProjectRegion, String> implements IHmProjectRegionDao {

    public HmProjectRegionDaoImpl(){
        super(HmProjectRegion.class);
    }
}