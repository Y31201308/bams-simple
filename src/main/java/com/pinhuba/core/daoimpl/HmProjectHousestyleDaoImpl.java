package com.pinhuba.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.dao.*;
/**
 * 表：HM_PROJECT_HOUSESTYLE 对应daoImpl
 */
@Repository
public class HmProjectHousestyleDaoImpl extends BaseHapiDaoimpl<HmProjectHousestyle, String> implements IHmProjectHousestyleDao {

    public HmProjectHousestyleDaoImpl(){
        super(HmProjectHousestyle.class);
    }
}