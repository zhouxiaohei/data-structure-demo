package com.zhou.demo.datastructure.algorithm.dynamic;

/**
 * @ClassName KnapsackProblem
 * @Author JackZhou
 * @Date 2020/9/9  19:29
 **/
public class KnapsackProblem {

    /**
      * @Author JackZhou
      * @Description  固定空间的背包N，  物品1 占用空间1.1  价值1.2   物品2 占用空间2.1  价值2.2  物品N
     *                将物品放入背包，物品不重复情况下背包价值最大
     **/
    public static void main(String[] args) {
        //二维数组 长度为3 宽度为2  [0][0] 第一个物品空间、[0][1] 第一个物品价值, 一共有三个物品
        int [][] goodsValue = {{1,100},{3,250},{2,200}};
        getOptimal(4, goodsValue);
        //getOptimal();
    }

    /**
      * @Author JackZhou
     * @Description  背包问题  能放入重复物品和不能放入重复物品     选择不能放入重复物品
     *   1、构建一个长度物品数量 + 1 ，宽度为背包大小 + 1 的二维数组; 方便第二步的计算,有第一行第一列0的默认值
     *   2、每一个数组位置的最优解等于
     *     ① 当前物品小于背包空间   当前物品 +  {剩余空间最优解}（背包空间-当前物品空间)[上一个物品在这个空间的最优解] 和 上一个物品当前背包大小比较   得到最优解
     *     ②当前物品大于背包空间   上一个物品当前背包大小是最优解
     *
     *     {剩余空间最优解}（背包空间-当前物品空间)[上一个物品在这个空间的最优解]   上一个物品的最优解代表物品不会重复
     **/
    public static void getOptimal(int knapsackSize, int [][] goodsValue){ //前面是大小、后面是价值
        int resultArr[][] = new int[goodsValue.length + 1][knapsackSize + 1]; //记录使用几个物品、空间为1-knapsackSize 时候最大值

        for(int i = 1; i< resultArr.length; i++){ //一个物品一个来
            for(int j =1; j < resultArr[0].length; j++){ // 背包大小从1开始
                if(goodsValue[i-1][0] <= j){ //判断当前物品大小和背包大小的关系
                     int max1 = goodsValue[i-1][1] + resultArr[i-1][j-goodsValue[i-1][0]]; //当前物品 +  {剩余空间最优解}（背包空间-当前物品空间)[上一个物品在这个空间的最优解]
                     int max2 = resultArr[i-1][j];
                     if(max1 > max2){
                         resultArr[i][j] = max1;
                     }else{
                         resultArr[i][j] = max2;
                     }
                }else{
                    resultArr[i][j] = resultArr[i-1][j];
                }
            }
        }
        System.out.println(resultArr[goodsValue.length][knapsackSize]);
    }
}
