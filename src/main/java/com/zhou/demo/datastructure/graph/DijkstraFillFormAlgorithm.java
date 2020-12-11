package com.zhou.demo.datastructure.graph;

import java.util.Arrays;

/**
 * @ClassName DijkstraFillFormAlgorithm
 * @Author JackZhou
 * @Date 2020/11/6  18:08
 **/
public class DijkstraFillFormAlgorithm {

    // 通过填表的方式解决 迪杰斯特拉  最短路径问题
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};

        //创建 Graph对象
        MyGraph graph = new MyGraph(vertex);
        graph.createGraph(matrix);
        graph.showGraph();

        NodeMinPath minPath = new NodeMinPath(graph);
        minPath.dijkstra(2);
        minPath.show();
    }

}

class NodeMinPath{

    private MyGraph graph;

    // 记录各个顶点是否访问过 1表示访问过,0未访问,会动态更新
    public int[] already_arr;
    // 每个下标对应的值为前一个顶点下标, 会动态更新
    public int[] pre_visited;
    // 记录出发顶点到其他所有顶点的距离,比如G为出发顶点，就会记录G到其它顶点的距离，会动态更新，求的最短距离就会存放到dis
    public int[] dis;

    /**
     * @param graph : 原始图
     */
    public NodeMinPath(MyGraph graph) {
        // 初始化最新路径 实体信息
        this.graph = graph;
        int length = graph.verxs;
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化 dis数组
        Arrays.fill(dis, 65535);
    }


    public void dijkstra(int startIndex) {
        this.already_arr[startIndex] = 1; //设置出发顶点被访问过
        this.dis[startIndex] = 0;//设置出发顶点的访问距离为0
        //每次添加一个新节点一个，更新最短距离和前驱节点
        updateMinPath(startIndex);
        for(int i = 1; i < already_arr.length; i++){
            int nextNode = getNextNode();
            updateMinPath(nextNode);
        }
    }

    //根据传入的出发顶点  更新从开始顶点到目标顶点的最短距离以及对应的前驱节点
    private void updateMinPath(int startIndex){
        for(int i = 0; i < already_arr.length; i++){
            int len = dis[startIndex] + graph.weight[startIndex][i];
            // 目标顶点未访问过、且index到目标顶点的距离小于 之前的距离
            //更新index为访问i的前驱节点、同时更新距离
            if(already_arr[i] == 0 && len <dis[i]){
               pre_visited[i] = startIndex;
               dis[i] = len;
            }
        }
    }

    // 通过计算最短路径的方式更新的最短路径、为访问过的路径最短的顶点即是下一个被访问的顶点。
    private int getNextNode(){
        int min = 65535, index = 0;
        for(int i = 0; i < already_arr.length; i++){
            if(already_arr[i] == 0 &&dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        //更新 index 顶点被访问过
        already_arr[index] = 1;
        return index;
    }

    //显示最后的结果
    //即将三个数组的情况输出
    public void show() {

        System.out.println("==========================");
        //输出already_arr
        for(int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for(int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "("+i+") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();

    }

}
