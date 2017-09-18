package com.fenfei.ssh.aop.aop01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by shefenfei on 2017/8/3.
 */
public class LogInput implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String className = target.getClass().getName();
        String methodName = method.getName();

        System.out.println("Executing method "+methodName+" of class "+className+" with following parameters");
        for(Object parameter: args){
            System.out.println(parameter.getClass().getName() + " = "+parameter.toString());
        }
    }
}
