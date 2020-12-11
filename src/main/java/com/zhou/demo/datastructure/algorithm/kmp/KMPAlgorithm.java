package com.zhou.demo.datastructure.algorithm.kmp;

import java.util.Arrays;

/**
 * @ClassName KMPAlgorithm
 * @Author JackZhou
 * @Date 2020/9/17  16:48
 **/
public class KMPAlgorithm {

    public static void main(String[] args) {
        //String dest = "ABCDABBABC";
        String dest = "AABCAAABDAAAAB";
        System.out.println(Arrays.toString(kmpNext(dest)));
    }
    //获取到一个字符串(子串) 的部分匹配值表
    public static  int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        for(int i = 1, j = 0; i < dest.length(); i++) {//遍历目标字符串、从i开始； J表示要匹配的字符

            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出   或者J到了最开始处0
            // AABCAAABDAAAAB 理解为什么有dest.charAt(i) != dest.charAt(j)
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];//
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
