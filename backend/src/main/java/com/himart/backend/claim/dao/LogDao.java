package com.himart.backend.claim.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogDao {
    Long insertMonitoringLog(String json);
    void updateMonitoringLog(String json);
}
