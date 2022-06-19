package com.himart.backend.claim.utils.helper;

import com.himart.backend.claim.dao.LogDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MonitoringLogHelper {

    private final LogDao logDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long insertMonitoringLog(String json) {
        //TODO logDao.insertMonitoringLog(json)
        return 0L;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateMonitoringLog(String json, Long logKey) {
        //TODO logDao.updateMonitoringLog(json);
    }

}
