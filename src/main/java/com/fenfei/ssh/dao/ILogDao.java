package com.fenfei.ssh.dao;

import com.fenfei.ssh.pojos.system.OptLog;

/**
 * Created by shefenfei on 2017/9/5.
 */
public interface ILogDao {

    long insertLog(OptLog optLog);
}
