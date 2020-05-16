package com.djh.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author AceDJH
 * @Date 2020/5/16 15:08
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
@Component("logger")
// 表示当前类是一个切面类
@Aspect
public class Logger {
    @Pointcut("execution(* com.djh.service.impl.*.*(..))")
    private void pt1(){
    }

    // 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
    @Before("pt1()")
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志了");
    }
    // 环绕通知
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint point){
        Object rtValue = null;
        try {
            // 得到方法执行所需的参数
            Object[] args = point.getArgs();
            // 明确调用业务层方法（切入点方法）
            rtValue = point.proceed(args);
            return rtValue;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException();
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了");
        }
    }
}
