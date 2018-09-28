package com.example.ccx.util;

import java.util.LinkedList;

import xiaofei.library.datastorage.annotation.ClassId;

/**
 * Created by ccx on 18/09/27.
 */
@ClassId("MyStack")
public class MyStack<T> {
    private LinkedList<T> lList;

    /**
     *判空
     */
    public boolean isEmpity(){
        return lList.isEmpty();
    }

    /**
     *清空
     */
    public void clear(){
        lList.clear();
    }

    /**
     *获得栈首（不删除）
     */
    public T getTop(){
        if (lList != null && !isEmpity()){
            return lList.peekFirst();
        }
        return null;
    }

    /**
     *获得栈尾（不删除）
     */
    public T getBottom(){
        if (lList != null && !isEmpity()){
            return lList.peekLast();
        }
        return null;
    }

    /**
     * 入栈
     */
    public void push(T t){
        if(lList == null){
            lList = new LinkedList<>();
        }
        lList.addFirst(t);
    }

    /**
     *出栈
     */
    public T pop(){
        if(lList != null && !isEmpity()){
            return lList.removeFirst();
        }
        return null;
    }
}
