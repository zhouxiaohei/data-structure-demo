package com.zhou.demo.datastructure.linkedlist;

/**
 * @ClassName Josepfu
 * @Author JackZhou
 * @Date 2020/4/29  15:32
 *    约瑟夫问题  约瑟夫环  丢手帕
 *    一群小孩围成一个圈、总数sum、丢手绢N次后小孩出列、最后剩下的小孩
 **/
public class Josepfu {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //play(111225, 10, 13); //1037ms
        playBreakLoop(11, 10, 3); //跳出多个循环  1342s  超过10w 这个才快一点哦
        System.out.println("cost:" + (System.currentTimeMillis() - start));

        //单向循环链表 约瑟夫  arrayList反转
    }

    /**
     * @Author JackZhou
     * @Description  记录前一个元素，当记录为1时，前一个元素就是最后一个元素
     **/
    public static void play(int sum, int begin, int interval){
        int[] sumArr = new int[sum];
        //初始化
        for(int i = 0; i < sum; i++){
            sumArr[i] = i + 1;
        }

        if(begin >= sum || sum == 1){
            throw new RuntimeException("输入的值不合法");
        }

        int count = 0;
        int pre = 0;
        while(sum > 1){
            for(int i = 0; i < sumArr.length; i++){
                //先到开始位置
                if(i < begin -1){
                    continue;
                }
                begin = 0;

                if(sumArr[i] != 0){
                    count++;
                    if(count == interval){
                        System.out.println("出局的编号" + sumArr[i]);
                        sumArr[i] = 0;
                        sum--;
                        count = 0;
                        // 总数为1，停止循环
                        if(sum == 1){
                            System.out.println("最后剩下的王者是:" + pre);
                            break;
                        }
                    }else{
                        pre = sumArr[i];
                    }
                }
            }
        }
    }

    /**
     * @Author JackZhou
     * @Description  跳出两层循环；多循环一次找最后一个元素；不用记录前一个元素
     **/
    public static void playBreakLoop(int sum, int begin, int interval){
        int[] sumArr = new int[sum];
        //初始化
        for(int i = 0; i < sum; i++){
            sumArr[i] = i + 1;
        }

        if(begin >= sum || sum == 1){
            throw new RuntimeException("输入的值不合法");
        }

        int count = 0;
        bbloop: while(true){
            for(int i = 0; i < sumArr.length; i++){
                //先到开始位置
                if(i < begin -1){
                    continue;
                }
                begin = 0;

                if(sumArr[i] != 0){
                    count++;
                    if(count == interval){
                        // 总数为1，停止循环
                        if(sum == 1){
                            System.out.println("最后剩下的王者是:" + sumArr[i]);
                            break bbloop;
                        }
                        System.out.println("出局的编号" + sumArr[i]);
                        sumArr[i] = 0;
                        sum--;
                        count = 0;
                    }
                }
            }
        }
    }
}


