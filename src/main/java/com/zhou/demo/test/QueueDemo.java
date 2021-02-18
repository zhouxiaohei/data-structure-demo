package com.zhou.demo.test;

import java.util.Stack;
import java.util.TreeMap;

/**
 * @ClassName QueueDemo
 * @Author JackZhou
 * @Date 2021/1/14  19:22
 **/
public class QueueDemo {
    private Stack<String> stackA;
    private Stack<String> stackB;

    public static void main(String[] args) {
        TreeMap map = new TreeMap();
    }

    public QueueDemo(){
        stackA = new Stack<String>();
        stackB = new Stack<String>();
    }

    public void push(String message){
        while(!stackB.empty()){
            stackA.push(stackB.pop());
        }
        stackA.add(message);
        stackB.clear();
    }

    public String get(){
        stackB.addAll(stackA);
        stackA.clear();
        return stackB.pop();
    }

}
