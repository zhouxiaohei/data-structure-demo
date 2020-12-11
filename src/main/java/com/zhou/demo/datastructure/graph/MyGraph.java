package com.zhou.demo.datastructure.graph;

import java.util.Arrays;

/**
 * @ClassName MyGraph
 * @Author JackZhou
 * @Date 2020/11/6  11:48
 **/
public class MyGraph {

    int verxs; //表示图的节点个数
    char[] data;//存放结点数据
    int[][] weight; //存放边，就是我们的邻接矩阵

    public MyGraph(char[] data) {
        this.verxs = data.length;
        this.data = new char[this.verxs];
        for (int i = 0; i < verxs; i++) {//顶点
            this.data[i] = data[i];
        }
        weight = new int[verxs][verxs];
    }


    //创建图的邻接矩阵数据
    /**
     * @param weight 图的邻接矩阵
     */
    public void createGraph(int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {//顶点
            for (j = 0; j < verxs; j++) {
                this.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph() {
        for (int[] link : this.weight) {
            System.out.println(Arrays.toString(link));
        }
    }
}
