package com.fenfei.ssh.service.impl;

import com.fenfei.ssh.dao.ILogDao;
import com.fenfei.ssh.pojos.system.OptLog;
import com.fenfei.ssh.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shefenfei on 2017/9/5.
 */
@Service
public class ILogServiceImpl implements ILogService {

    @Autowired
    private ILogDao logDao;

    @Override
    public long insertLog(OptLog optLog) {
        return logDao.insertLog(optLog);
    }
}
