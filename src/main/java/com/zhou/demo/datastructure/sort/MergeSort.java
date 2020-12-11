package com.zhou.demo.datastructure.sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Author JackZhou   归并排序
 * @Date 2020/5/19  17:40
 **/
public class MergeSort {
    public static void main(String[] args) {
        //simpleTest();
        performanceTest(80000000); // 8w 21-23ms  80w 150~200ms 800w 1.6~1.9s   两边基准比中间基准要快一点
    }

    public static void simpleTest(){
         int[] arr = {1,13,2,10,9,4,15};
        //int[] arr = {1, 2, 3, 1, 5, 1, 1 };
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
        int tmp [] = new int[arr.length]; //归并排序需要一个额外空间
        sort(arr, 0, arr.length-1, tmp);
    }

    public static void sort(int[] arr, int left, int right,  int[] tmp){
        if(left < right){
            int mid = (left + right)/2;
            sort(arr, left, mid, tmp);
            sort(arr, mid +1, right, tmp);
            mergeSort(arr, left, mid, right, tmp);
        }
    }

    // 合并有序数组
    public static void mergeSort(int[] arr, int left, int mid, int right, int[] temp){
        int i = left; // 初始化i, 左边有序序列的初始索引
        int j = mid + 1; //初始化j, 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 t++, i++
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之,将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while( i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while( j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }


        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left; //
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
