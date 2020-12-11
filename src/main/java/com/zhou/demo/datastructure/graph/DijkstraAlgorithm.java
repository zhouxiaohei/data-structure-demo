package com.zhou.demo.datastructure.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName DijkstraAlgorithm
 * @Author JackZhou
 * @Date 2020/11/6  11:12
 *
 *  迪杰斯特拉   最短路径算法---贪心算法
 *
 *  利用广度优先，以起点为中心向外扩散，直到扩展到终点。
 *
 * （每次选取可达范围内最近的节点、就是最近的。）
 * 使用顶点访问所有其他节点、记录到其他节点的距离。
 * 每次选取距离已访问顶点最近的顶点，加入到已访问顶点集合；
 * 每次加入顶点以后，重新计算最近的顶点距离列表，选出距离最近的。
 *
 **/
public class DijkstraAlgorithm {

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

        dijkstra(graph, 1);
    }

    // 前驱节点和 最短距离
    public static void dijkstra(MyGraph graph, int startIndex) {
        // 已访问的顶点集合
        int minLength = 65535;

        //节点和距离
        Map<Integer, Integer> map = new HashMap<>();
        map.put(startIndex, 0);

        int endIndex = -1;

        // 访问节点数减1次，第一个节点已访问
        for (int i = 1; i < graph.verxs; i++) {
            // 出发节点，每次得到最小值以后增加
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            for (int j = 0; j < map.size(); j++) {
                Map.Entry<Integer, Integer> next = iterator.next();
                int s = next.getKey();
                // 目标节点
                for (int k = 0; k < graph.verxs; k++) {
                    if (!map.containsKey(k)) {
                        // 出发节点到当前节点、当前节点到下一个节点
                        int size = map.get(s) + graph.weight[s][k];
                        if (size < minLength) {
                            minLength = size;
                            endIndex = k;
                        }

                    }
                }
            }

            if (endIndex == -1) {
                System.out.println("此路不通，请交钱！");
            }
            map.put(endIndex, minLength);
            endIndex = 0;
            minLength = 65535;

        }

        //打印展示
        char startNode = graph.data[startIndex];

        Iterator<Map.Entry<Integer, Integer>> iterator =    map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println("从" + startNode + "到" + graph.data[next.getKey()] + "的最短距离是：" + next.getValue());
        }
    }

}
