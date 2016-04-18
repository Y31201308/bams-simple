package com.pinhuba.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.dao.*;
/**
 * 表：HM_HOUSE_INFO 对应daoImpl
 */
@Repository
public class HmHouseInfoDaoImpl extends BaseHapiDaoimpl<HmHouseInfo, String> implements IHmHouseInfoDao {

    public HmHouseInfoDaoImpl(){
        super(HmHouseInfo.class);
    }
}