/**
 * Miguel Created: 2017/06/06
 */
package com.cicha.methodname;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Miguel
 */
public interface MethodNameListener extends Comparable<MethodNameListener> {

    public Integer getPriority();

    public void onMethodInvokeBefore(MethodName methodName, JoinPoint joinPoint) throws Exception;

    public void onMethodInvokeAfter(MethodName methodName, Object res, JoinPoint joinPoint) throws Exception;
}
