package com.zhou.demo.datastructure.sort;

import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Author JackZhou
 * @Date 2020/5/7  14:58
 * @Desc 选择排序  选择最小/大的放在第一位；依次循环；
 **/
public class SelectSort {
    public static void main(String[] args) {
        //simpleTest();
        performanceTest(80000);
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
        int[] arr = {1,13,2,10,9,4,15};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int min = 0; // 记录最小值
        int index = 0; //记录下标用于交换
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            index = 0;
            for (int j = i +1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if(index != 0){
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
