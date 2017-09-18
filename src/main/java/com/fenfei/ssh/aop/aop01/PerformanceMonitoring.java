package com.fenfei.ssh.aop.aop01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by shefenfei on 2017/8/3.
 */
public class PerformanceMonitoring implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken in ms : "+(endTime-startTime));
        return result;
    }
}
