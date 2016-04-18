package com.pinhuba.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.dao.*;
/**
 * 表：HM_PROJECT 对应daoImpl
 */
@Repository
public class HmProjectDaoImpl extends BaseHapiDaoimpl<HmProject, String> implements IHmProjectDao {

    public HmProjectDaoImpl(){
        super(HmProject.class);
    }
}