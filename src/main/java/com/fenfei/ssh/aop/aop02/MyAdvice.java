package com.fenfei.ssh.aop.aop02;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by shefenfei on 2017/8/4.
 */
//通知 定义了要什么时间使用
public class MyAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    Logger logger = Logger.getLogger(MyAdvice.class);
    int afterCount = 0;
    int beforeCount = 0;

    //在方法返回以后使用
    @Override
    public void afterReturning(Object target, Method method, Object[] objects, Object o1) throws Throwable {
        logger.info("afterReturning....." + afterCount++);
    }

    //在方法执行前使用
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.info("before....." + beforeCount++);
    }
}
