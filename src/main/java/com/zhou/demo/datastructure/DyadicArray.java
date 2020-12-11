package com.zhou.demo.datastructure;

import java.util.Arrays;

/**
 * @ClassName DyadicArray
 * @Author JackZhou
 * @Date 2020/10/28  14:27
 **/
public class DyadicArray {

    public static void main(String[] args) {
        //printTest;
        //printDyadicArray(createOne(5, 5));
        printDyadicArray(createThree(5));
    }

    public void demo(){
        //创建方式1
        int[][] demoArray  = new int[3][2];

        //创建方式2 长度为3  宽度为2
        int [][] goodsValue = {{1,100},{3,250},{2,200}};

        //第三种方式：第二维的长度可以动态申请
        int[][] arr3 = new int[5][];//五行的长度
        for(int i=0; i<arr3.length; ++i){
            arr3[i]=new int[i+1];   //列的长度每次都变化。每次都要重新申请空间(长度)
            for(int j=0; j<arr3[i].length; ++j){
                arr3[i][j]= i+j;
            }
        }
    }

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
