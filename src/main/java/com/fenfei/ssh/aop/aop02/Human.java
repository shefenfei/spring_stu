package com.fenfei.ssh.aop.aop02;

import org.apache.log4j.Logger;

/**
 * Created by shefenfei on 2017/8/4.
 */
//相当于一个目标 Target
public class Human implements ISleepAble{

    Logger logger = Logger.getLogger(Human.class);

    @Override
    public void sleep() {
        logger.info("要睡了...");
    }
}
