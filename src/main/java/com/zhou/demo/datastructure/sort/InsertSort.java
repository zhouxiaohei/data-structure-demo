package com.zhou.demo.datastructure.sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Author JackZhou
 * @Date 2020/5/7  19:08
 * @Desc  把n个待排序的元素看成为包含一个元素的有序表和包含N-1个元素无序表
 **/
public class InsertSort {

    public static void main(String[] args) {
        //simpleTest();
        performanceTest(80000); //2s
    }

    public static void simpleTest(){
        int[] arr = {1,13,2,10,9,4,15};
        sort(arr);
        System.out.println(Arrays.toString(arr));
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

    public static void sort(int[] arr){
        //使用for循环来把代码简化
        for(int i = 1; i < arr.length; i++) {
            //当前比较的值和下标
            int insertValue = arr[i];
            // 循环有序数组   如果小于，就交换
            for(int j = i-1; j>=0; j--){
                if(insertValue < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = insertValue;
                }else{
                    break;
                }
            }
        }
    }
}
