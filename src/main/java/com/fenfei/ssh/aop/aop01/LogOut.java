package com.fenfei.ssh.aop.aop01;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by shefenfei on 2017/8/3.
 */
public class LogOut implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        String className = target.getClass().getName();
        String methodName = method.getName();
        System.out.println("Returning from method "+methodName+" of class "+className+" with "+returnValue.toString());
    }
}
