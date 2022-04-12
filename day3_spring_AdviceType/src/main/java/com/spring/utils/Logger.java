package com.spring.utils;

/**
 * 用于记录日志的工具类，里面提供了公共的代码
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("Logger类中的方法beforePrintLog开始记录日志了。。。。");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("Logger类中的方法afterReturningPrintLog开始记录日志了。。。。");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("Logger类中的方法afterThrowingPrintLog开始记录日志了。。。。");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("Logger类中的方法开始记录日志了。。。。");
    }
}
