package com.zhou.demo.datastructure.sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Author JackZhou
 * @Date 2020/5/9  23:00
 * @Desc  shell排序   希尔排序是对插入排序的优化；增加步长的概念，对步长相关的进行插入排序；当步长为1时排序成功；借鉴插入排序对有序数据效率高的特点；
 **/
public class ShellSort {

    public static void main(String[] args) {
        //simpleTest();
        performanceTest(8000000); //8w数据20-30ms！！  80w数据225ms！ 800w数据 2-3s！ 优秀
    }

    public static void performanceTest(int size){
        int[] arr = new int[size];
        for(int i =0; i < size;i++) {
            arr[i] = (int)(Math.random() * size); //生成一个[0, 8000000) 数
        }
        long begin = System.currentTimeMillis();
        sort(arr);
        System.out.println("cost:" + (System.currentTimeMillis() - begin));
    }

    public static void simpleTest(){
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2; i > 0; i = i / 2) {

            //借用插入排序  搞清楚插入排序
            for (int j = i; j < arr.length; j++) {
                int insertValue = arr[j];
                // 循环有序数组   如果小于，就交换
                for(int h = j-i; h>=0; h = h-i){
                    if(insertValue < arr[h]){
                        arr[h+i] = arr[h];
                        arr[h] = insertValue;
                    }else{
                        break;
                    }
                }
            }
        }
    }

}
