package com.example.ccx.util;

import java.util.LinkedList;

import xiaofei.library.datastorage.annotation.ClassId;

/**
 * Created by ccx on 18/09/27.
 */
@ClassId("MyQueue")
public class MyQueue<T> {
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
     *获得队首（不删除）
     */
    public T getFront(){
        if (lList != null && !isEmpity()){
            return lList.peekFirst();
        }
        return null;
    }

    /**
     *获得队尾（不删除）
     */
    public T getRear(){
        if (lList != null && !isEmpity()){
            return lList.peekLast();
        }
        return null;
    }

    /**
     * 入队
     */
    public void push(T t){
        if(lList == null){
            lList = new LinkedList<>();
        }
        lList.add(t);
    }

    /**
     *出队
     */
    public T pop(){
        if(lList != null && !isEmpity()){
            return lList.removeFirst();
        }
        return null;
    }
}
