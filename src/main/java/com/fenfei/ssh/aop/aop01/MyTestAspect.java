package com.fenfei.ssh.aop.aop01;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by shefenfei on 2017/8/3.
 */
@Aspect
@Component
public class MyTestAspect {

    private Logger logger = Logger.getLogger(MyTestAspect.class);

    private int arg1;
    private String arg2;

    public void testA() {
        logger.info("testA");

    }


    @Pointcut("execution(* transfer(..))") //点切表达式
    private void anyOldTransfer() { //点切的方法签名
        logger.info("excuteion ...");
    }


    @Pointcut("within(com.fenfei.ssh.controller..*)")
    private void inWebLayer() {

    }


    @Pointcut("within(com.fenfei.ssh.service..*)")
    private void inServiceLayer() {

    }

}
