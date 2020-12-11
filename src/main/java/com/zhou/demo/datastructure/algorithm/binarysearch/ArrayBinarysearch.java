package com.zhou.demo.datastructure.algorithm.binarysearch;

/**
 * @ClassName ArrayBinarysearch
 * @Author JackZhou
 * @Date 2020/9/2  20:51
 **/
public class ArrayBinarysearch {

    /**
      * @Author JackZhou
      * @Description  以升序数组为例使用二分查找算法
     **/
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        //System.out.println(loopSearch(arr, 101));
        System.out.println(recursionSearch(arr, 1));
    }

    /**
      * @Author JackZhou
      * @Description   递归二分查找
     **/
    public static int recursionSearch(int[] arr, int target){
        return search(arr, 0, arr.length-1, target);
    }

    public static int search(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int min = (left + right) / 2;
            if (arr[min] == target) {
                return min;
            } else if (arr[min] > target) {
                right = min - 1;
                return search(arr, left, right, target);
            } else {
                left = min + 1;
                return search(arr, left, right, target);
            }
        }
        return -1;
    }

    /**
      * @Author JackZhou
      * @Description  循环二分查找
     **/
    public static int loopSearch(int[] arr, int target){
        int left = 0;
        int right = arr.length -1;

        while(left <= right){
            int min = (left + right) /2;
            if(arr[min] == target){
                return min;
            }else if(arr[min] > target){
                right = min -1;
            }else{
                left = min + 1;
            }
        }
        return -1;
    }
}
