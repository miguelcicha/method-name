/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cicha.methodname;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

/**
 *
 * @author Cicha
 */
@Aspect
public class MethodNameAspect {

    @Before("execution(@MethodName  * *.*(..))")
    public void before(JoinPoint joinPoint) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MethodName methodName = method.getAnnotation(MethodName.class);
        MethodNameFire.fireBefore(methodName, joinPoint);
    }

    @AfterReturning(pointcut = "execution(@MethodName  * *.*(..))", returning = "res")
    public void after(JoinPoint joinPoint, Object res) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MethodName methodName = method.getAnnotation(MethodName.class);
        MethodNameFire.fireAfter(methodName, res, joinPoint);
    }

}
