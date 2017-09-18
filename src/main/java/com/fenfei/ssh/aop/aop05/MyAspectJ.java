package com.fenfei.ssh.aop.aop05;

import com.fenfei.ssh.aop.aop04.MyAspect;
import com.fenfei.ssh.pojos.system.Administrator;
import com.fenfei.ssh.pojos.system.OptLog;
import com.fenfei.ssh.service.ILogService;
import com.fenfei.ssh.utils.IdGenerator;
import com.fenfei.ssh.utils.SystemControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by shefenfei on 2017/8/29.
 */
@Aspect
@Component
public class MyAspectJ {

    Logger logger = LoggerFactory.getLogger(MyAspect.class);

    private static final ThreadLocal<Date> beginTimeThreadLocal =
            new NamedThreadLocal<>("ThreadLocal beginTime");

    private static final ThreadLocal<OptLog> logThreadLocal =
            new NamedThreadLocal<>("ThreadLocal log");

    private static final ThreadLocal<Administrator> currentAdmin =
            new NamedThreadLocal<>("ThreadLocal admin");


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ILogService logService;


    //@Pointcut("execution(* com.fenfei.ssh.controller.*Controller.*(..)) ")
    //we define a pointcut for all controllers
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void classPointcut() {

    }

    // all the methods join to this pointcut
    @Pointcut("execution(* *(..)) ")
    public void methodPointcut() {

    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作的开始时间
     */
    @Before("classPointcut() && methodPointcut()")
    public void recordBefore(JoinPoint joinPoint) throws InterruptedException {
        logger.info(joinPoint.getArgs() + ".." + joinPoint.getKind() + "..." + joinPoint.getSignature().getDeclaringTypeName());

        Date beginTime = new Date();
        beginTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
        if (logger.isDebugEnabled()) {//这里日志级别为debug
            logger.error("开始计时: {}  URI: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(beginTime), request.getRequestURI());
        }

        //读取session中的用户
        HttpSession session = request.getSession();
        Administrator user = (Administrator) session.getAttribute("current_admin");
        currentAdmin.set(user);
    }


    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     */
    @After("classPointcut() && methodPointcut()")
    public void record(JoinPoint joinPoint) {
        Administrator user = currentAdmin.get();
        if (user != null) {
            String title = "";
            String type = "info";                       //日志类型(info:入库,error:错误)
            String remoteAddr = request.getRemoteAddr();//请求的IP
            String requestUri = request.getRequestURI();//请求的Uri
            String method = request.getMethod();        //请求的方法类型(post/get)
            Map<String, String[]> params = request.getParameterMap(); //请求提交的参数

            try {
                title = getControllerMethodDescription2(joinPoint);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 打印JVM信息。
            long beginTime = beginTimeThreadLocal.get().getTime();//得到线程绑定的局部变量（开始时间）
            long endTime = System.currentTimeMillis();  //2、结束时间
            if (logger.isDebugEnabled()) {
                logger.error(
                        "计时结束：{}  URI: {}  耗时: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime),
                        request.getRequestURI());
            }

            OptLog log = new OptLog();
            log.setLogId(IdGenerator.genOptId16());
            log.setTitle(title);
            log.setType(type);
            log.setRemoteAddr(remoteAddr);
            log.setRequestUri(requestUri);
            log.setMethod(method);
            log.setUserId(user.getId());
            Date operateDate = beginTimeThreadLocal.get();
            log.setOperateDate(formatTime(new Date().getTime()));
            log.setTimeout(formatTime(endTime - beginTime));

            //1.直接执行保存操作
            this.logService.insertLog(log);

            //2.优化:异步保存日志
            //new SaveLogThread(log, logService).start();

            //3.再优化:通过线程池来执行日志保存
//            threadPoolTaskExecutor.execute(new SaveLogThread(log, logService));
//            logThreadLocal.set(log);
            logger.error("操作日志:{}" , log.toString());
        }
        long beginTime = beginTimeThreadLocal.get().getTime();//得到线程绑定的局部变量（开始时间）
        long endTime = System.currentTimeMillis();  //2、结束时间

        logger.error("操作结束: 用时 :{} ms" , endTime - beginTime );
    }

    private String formatTime(long l) {
        Date date = new Date();
        date.setTime(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        return time;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return discription
     */
    public static String getControllerMethodDescription2(JoinPoint joinPoint) {
        String discription = "暂无信息";
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemControllerLog controllerLog = method.getAnnotation(SystemControllerLog.class);
        if (controllerLog != null) {
            discription = controllerLog.description();
        }
        return discription;
    }

}
