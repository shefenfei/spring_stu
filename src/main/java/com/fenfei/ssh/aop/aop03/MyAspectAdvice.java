package com.fenfei.ssh.aop.aop03;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by shefenfei on 2017/8/4.
 */
@Aspect
@Component
public class MyAspectAdvice {

    public MyAspectAdvice() {
    }

    @Pointcut("execution(* com.fenfei.ssh.aop.aop02.Human.sleep(..))")
    public void sleepPoint() {
    }

    //这个叫Advice
    @Before("sleepPoint()")
    public void beforeSleep(){
        System.out.println("睡觉前要脱衣服!");
    }

    //
    @AfterReturning("sleepPoint()")
    public void afterSleep(){
        System.out.println("睡醒了要穿衣服！");
    }
}
