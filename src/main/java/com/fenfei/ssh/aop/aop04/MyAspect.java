package com.fenfei.ssh.aop.aop04;

import org.apache.log4j.Logger;

/**
 * Created by shefenfei on 2017/8/4.
 */
public class MyAspect {

    Logger logger = Logger.getLogger(MyAspect.class);

    public void afterReturning() throws Throwable {
        logger.info("afterReturning");
    }

    public void before() throws Throwable {
        logger.info("before...." );
    }
}
