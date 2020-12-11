package com.zhou.demo.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PrimAlgorithm
 * @Author JackZhou
 * @Date 2020/9/24  19:29
 * @Desc  普利姆算法
 *    访问第一个顶点A可以到达的最短顶点N；再访问A和N可以到达的最短权值顶点
 *    持续上面的动作，一直到节点全部访问结束或者说N-1条边；
 **/
public class PrimAlgorithm {

    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight =  new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MyGraph graph = new MyGraph(data);
        graph.createGraph(weight);

        graph.showGraph();

        primMinTree(graph, 0);

    }

    /**
     * @Description
     * @Date 2020/11/4 17:50
     * @Param [graph, v] 图 以及从哪个顶点开始遍历
     **/
    public static void primMinTree(MyGraph graph, int startIndex) {
        //已访问的顶点
        List<Integer> list = new ArrayList<>();
        list.add(startIndex);

        int minSize = 10000;

        //记录两个顶点方便打印
        int h1 = 0, h2 = 0;

        //需要得到N-1条边，进行N-1次遍历
        for (int i = 1; i < graph.verxs; i++) {
            //出发的节点
            for (int s = 0; s < list.size(); s++) {
                //结束的节点
                int sIndex = list.get(s);
                for (int e = 0; e < graph.verxs; e++) {
                    if (!list.contains(e) && graph.weight[sIndex][e] < minSize) {
                        minSize = graph.weight[sIndex][e];
                        h1 = sIndex;
                        h2 = e;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minSize);
            list.add(h2);
            // 重置状态
            minSize = 10000;
        }
    }
}


