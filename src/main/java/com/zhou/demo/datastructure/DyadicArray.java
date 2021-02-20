package com.zhou.demo.datastructure;

import java.util.Arrays;

/**
 * @ClassName DyadicArray
 * @Author JackZhou
 * @Date 2020/10/28  14:27
 * @desc  二维数组的简单使用
 **/
public class DyadicArray {

    public static void main(String[] args) {
        printDyadicArray(createOne(5, 5));
        //printDyadicArray(createThree(5));
        //showDyadicArray(createThree(5));
    }

    // 创建二维数组demo
    public void createDemo() {
        //创建方式1
        int[][] demoArray = new int[3][2];

        //创建方式2 长度为3  宽度为2
        int[][] goodsValue = {{1, 100}, {3, 250}, {2, 200}};

        //第三种方式：第二维的长度可以动态申请
        int[][] arr3 = new int[5][];//长度为5
        for (int i = 0; i < arr3.length; ++i) {
            arr3[i] = new int[i + 1];   //列的长度每次都变化。每次都要重新申请空间(长度)  长度1~6
            for (int j = 0; j < arr3[i].length; ++j) {
                arr3[i][j] = i + j;
            }
        }
    }

    // 根据长宽创建二维数组
    public static int[][] createOne(int len, int wid){
        int[][] demoArray  = new int[len][wid];
        int rowNum = 0;
        for(int[] row : demoArray){
            rowNum ++;
            for(int i =0; i< row.length; i++){
                demoArray[rowNum -1][i] = Integer.parseInt(rowNum  + "" + i);
            }
        }
        System.out.println("数组长度 : " + demoArray.length);
        System.out.println("数组宽度 : " + demoArray[0].length);
        return demoArray;
    }

    //根据长创建二维数组、宽依次增大
    public static int[][] createThree(int len) {
        int[][] demoArray = new int[len][];
        for (int i = 0; i < demoArray.length; ++i) {
            demoArray[i] = new int[i + 1];   //列的长度每次都变化。每次都要重新申请空间(长度)
            for (int j = 0; j < demoArray[i].length; ++j) {
                demoArray[i][j] = i + j;
            }
        }
        return demoArray;
    }

    public static void printTest(){
        //长度为3  宽度为2
        int [][] goodsValue = {{1,100},{3,250},{2,200}};
        showDyadicArray(goodsValue);
        printDyadicArray(goodsValue);
    }

    // 打印二维数组的两种方式
    public static void showDyadicArray(int[][] intArr) {
        for(int[] row : intArr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printDyadicArray(int[][] intArr){
        for (int[] row : intArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
