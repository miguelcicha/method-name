/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cicha.methodname;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Cicha
 */
public class MethodNameFire {

    private final static List<MethodNameListener> methodNameListenersBefore = new CopyOnWriteArrayList<>();
    private final static List<MethodNameListener> methodNameListenersAfter = new CopyOnWriteArrayList<>();

    public static void fireBefore(MethodName mn, JoinPoint joinPoint) throws Exception {
        for (MethodNameListener mnl : methodNameListenersBefore) {
            mnl.onMethodInvokeBefore(mn, joinPoint);
        }
    }

    public static void fireAfter(MethodName mn, Object res, JoinPoint joinPoint) throws Exception {
        for (MethodNameListener mnl : methodNameListenersAfter) {
            mnl.onMethodInvokeAfter(mn, res, joinPoint);
        }
    }

    public static void addMethodNameListenersBefore(MethodNameListener lmi) {
        methodNameListenersBefore.add(lmi);
        Collections.sort(methodNameListenersBefore);
    }

    public static void removeMethodNameListenersBefore(MethodNameListener lmi) {
        methodNameListenersBefore.remove(lmi);
    }

    public static void addMethodNameListenersAfter(MethodNameListener lmi) {
        methodNameListenersAfter.add(lmi);
        Collections.sort(methodNameListenersAfter);
    }

    public static void removeMethodNameListenersAfter(MethodNameListener lmi) {
        methodNameListenersAfter.remove(lmi);
    }

}
