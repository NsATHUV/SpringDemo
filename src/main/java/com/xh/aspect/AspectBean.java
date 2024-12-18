package com.xh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("aspect")
@Aspect
public class AspectBean {

    @Pointcut(value = "execution(* com.xh.dao.impl.*.*(..))")
    public void myput() {
    }


    //前置通知
    @Before("myput()")
    public void doBefore(JoinPoint jp) {
        System.out.println("[Before] 调用之前：" + jp.getTarget().getClass().getCanonicalName() + "." + jp.getSignature().getName() + "：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println();
    }

    //后置通知
    @After("myput()")
    public void doAfter(JoinPoint jp) {
        System.out.println("[After] 调用之后：" + jp.getTarget().getClass().getCanonicalName() + "." + jp.getSignature().getName() + "：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println();
    }

    //环绕通知
    //拦截住方法
    @Around("myput()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        //继续向后执行
        Object result = pjp.proceed();
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println("[Around] 共耗时：" + (endTime - startTime) + "ms");
        return result;
    }

    //异常通知
    //Throwable:表示异常信息
    @AfterThrowing(value = "myput()", throwing = "ex")
    public void doThrow(JoinPoint jp, Throwable ex) {
        System.out.println("[Throwing] 调用中：" + jp.getTarget().getClass().getCanonicalName() + "." + jp.getSignature().getName() + "：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("出现了异常：" + ex.getMessage());
        System.out.println();
    }
}
