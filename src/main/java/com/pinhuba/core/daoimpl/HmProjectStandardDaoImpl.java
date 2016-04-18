package com.pinhuba.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.dao.*;
/**
 * 表：HM_PROJECT_STANDARD 对应daoImpl
 */
@Repository
public class HmProjectStandardDaoImpl extends BaseHapiDaoimpl<HmProjectStandard, String> implements IHmProjectStandardDao {

    public HmProjectStandardDaoImpl(){
        super(HmProjectStandard.class);
    }
}