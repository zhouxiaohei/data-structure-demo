package com.zhou.demo.datastructure.sort;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Author JackZhou
 * @Date 2020/5/7  12:43
 * @Desc  冒泡排序
 * 1、一共进行n-1次排序
 * 2、每一次排序逐渐减小，每一次得到最大(正序)或最小(倒叙)；最值不需要再次参与排序
 **/
public class BubbleSort {

    public static void main(String[] args) {
        //simpleTest();
        //TODO 80w 耗费太久了 cost 1711s 28.5min
        performanceTest(80000); // 8w数据  18-20s
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
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组");
            //System.out.println(Arrays.toString(arr));

            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
}
