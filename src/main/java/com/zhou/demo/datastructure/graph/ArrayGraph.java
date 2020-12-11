package com.zhou.demo.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName ArrayGraph
 * @Author JackZhou
 * @Date 2020/9/20  20:55
 * @desc  使用二维数组表示图  邻接矩阵
 **/
public class ArrayGraph {
    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的邻结矩阵
    private int numOfEdges; //表示边的数目

    public static void main(String[] args) {
        //测试一把图是否创建ok
        int n = 8;  //结点的个数
        //String Vertexs[] = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //创建图对象
        ArrayGraph graph = new ArrayGraph(n);
        //循环的添加顶点
        for(String vertex: Vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E
//		graph.insertEdge(0, 1, 1); // A-B
//		graph.insertEdge(0, 2, 1); //
//		graph.insertEdge(1, 2, 1); //
//		graph.insertEdge(1, 3, 1); //
//		graph.insertEdge(1, 4, 1); //

        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        //显示一把邻结矩阵
        graph.showGraph();
    }

    //构造器
    public ArrayGraph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }

    //显示图对应的矩阵
    public void showGraph() {
        for(int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //添加边
    /**
     *
     * @param v1 表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2 第二个顶点对应的下标
     * @param weight 表示0 表示不连通  1表示连通   或者 0表示不连通  N表示权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
