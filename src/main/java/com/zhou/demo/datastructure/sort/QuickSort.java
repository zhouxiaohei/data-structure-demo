package com.zhou.demo.datastructure.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Author JackZhou
 * @Date 2020/5/18  12:32
 * @Desc  快速排序
 * 思路： 选一个基准元素、将比基准小的放在左边，比基准大的放在右边，一直到左下标和右边下标重合，最后把基准元素放在中间；重复此过程一直到有序；
 **/
public class QuickSort {

    public static void main(String[] args) {
        //simpleTest();
        performanceTest(8000000); // 8w 33-70ms  80w 160~180ms 800w 1.7s   两边基准比中间基准要快一点
    }

    public static void simpleTest(){
        // int[] arr = {1,13,2,10,9,4,15};
        int[] arr = {1, 2, 3, 1, 1, 5, 1, 1 };
        //int[] arr = {5, 5, 4, 7, 0, 1, 0, 2 };
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

    public static void sort(int[] arr) {
        //sort(arr, 0, arr.length-1);
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int base = arr[(left+right)/2];
        int baseIndex = (left+right)/2;
        int l = left;
        int r = right;
        int tmp = 0;
        while(l != r){
            // 找到大于基准的值
            while(arr[l] <= base && l <r){
                l++;
            }
            //找到小于基准的值   两边准备交换
            while(arr[r] >= base && r >l){
                r--;
            }

            //以上两个while最终 左下标会等于右下标  右下标被迫不进行while循环
            if(l < r){
                tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        // 循环结束 l = r,   当前元素是大于基准元素的    ----- TODO 或者基准元素最大或者基准元素最小 两种情况
        // 从左开始  考虑基准元素最大    从右开始考虑基准元素最小
        if(arr[l] > base){
            if(l < baseIndex){  // 当前元素大于基准元素 、当前元素下标小于基准元素下标
                arr[baseIndex] = arr[l];
                arr[l] = base;
            }else{  // 当前元素大于基准元素 、当前元素下标大于基准元素下标
                l = l - 1;
                if(l != baseIndex){
                    arr[baseIndex] = arr[l];
                    arr[l] = base;
                }
            }
        }else if(arr[l] < base ){ // 基准元素最大的情况， 基准元素移动到最右
            arr[baseIndex] = arr[l];
            arr[l] = base;
        }

        //System.out.println(Arrays.toString(arr));
        //向左排序  向右排序  右边减一  左边加一 才能停止
        quickSort(arr, left, l-1);
        quickSort(arr, l+1, right);
    }

    /**
      * @Description  使用最左边和最右边   逻辑和算法更容易
     **/
    public static void sort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int l = left, r = right;
        while(l != r) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[r] >= base && l < r) {
                r--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[l] <= base && l < r) {
                l++;
            }

            // 上面的循环结束表示找到了位置或者(l>=r)了，交换两个数在数组中的位置
            if(l < r) {
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[l];
        array[l] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }

}
