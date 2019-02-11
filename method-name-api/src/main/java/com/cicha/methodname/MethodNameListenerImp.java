/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cicha.methodname;

/**
 *
 * @author Cicha
 */
public abstract class MethodNameListenerImp implements MethodNameListener {

    private Integer priority = 0;

    public MethodNameListenerImp() {
    }

     
    public MethodNameListenerImp(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(MethodNameListener o) {
        if (o == null || o.getPriority() == null) {
            return 0;
        }
        return priority.compareTo(o.getPriority());
    }
}
