package com.zhou.demo.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName QueueDemo
 * @Author JackZhou
 * @Date 2021/1/14  19:22
 **/
public class QueueDemo {
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public static void main(String[] args) {
        QueueDemo queue = new QueueDemo();
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        while (loop) {
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.put(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.take();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

    public QueueDemo(){
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();
    }

    public void put(Integer message){
        while(!stackB.empty()){
            stackA.push(stackB.pop());
        }
        stackA.add(message);
        stackB.clear();
    }

    public Integer take(){
        while(!stackA.empty()){
            stackB.push(stackA.pop());
        }
        stackA.clear();
        return stackB.pop();
    }

}
