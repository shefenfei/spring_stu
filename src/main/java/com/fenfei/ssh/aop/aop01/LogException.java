package com.fenfei.ssh.aop.aop01;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by shefenfei on 2017/8/3.
 */
public class LogException implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        String className = target.getClass().getName();
        String methodName = method.getName();

        System.out.println("Throwing exception from method "+methodName+" of class "+className);
        System.out.println("Exception message is "+ex.getMessage());
    }
}
