package com.pinhuba.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.dao.*;
/**
 * 表：HM_PROJECT_GROUP 对应daoImpl
 */
@Repository
public class HmProjectGroupDaoImpl extends BaseHapiDaoimpl<HmProjectGroup, String> implements IHmProjectGroupDao {

    public HmProjectGroupDaoImpl(){
        super(HmProjectGroup.class);
    }
}