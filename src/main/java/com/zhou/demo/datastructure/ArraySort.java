package com.zhou.demo.datastructure;

import java.util.Arrays;

/**
 * @ClassName ArraySort
 * @Author JackZhou
 * @Date 2020/11/16  18:06
 **/
public class ArraySort {

    public static void main(String[] args) {
        //simpleSort();
        //selfSortStrategy();
        //dyadicSort();
    }

    // 简单排序的应用
    public static void simpleSort() {
        int[] arrInt = {1, 3, 4, 2, 5, 2};
        //从小到大排序
        Arrays.sort(arrInt);
        //指定范围排序
        //Arrays.sort(arrInt, 0, 3);
        System.out.println(Arrays.toString(arrInt)); // 打印  [1, 2, 2, 3, 4, 5]

        // 字母排序
        char[] arrChar = {'c', 'a','3', 'z', '1','d', '4', 'c', 'b'};
        Arrays.sort(arrChar);
        System.out.println(Arrays.toString(arrChar)); //[1, 3, 4, a, b, c, c, d, z]
    }

    //反转或指定条件排序
    //public static <T> void sort(T[] a,int fromIndex, int toIndex, Comparator<? super T> c)
    // 如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值， 这样颠倒一下，就可以实现反向排序了
    public static void selfSortStrategy(){
        //TODO 对基本类型反序  Collections.reverseOrder()   不然要转换成引用类型
        int[] arrInt = {1, 3, 4, 2, 5, 2};
        //System.out.println(Arrays.sort(arrInt, Collections.reverseOrder()));

        Integer[] arrInteger = {1, 3, 4, 2, 5, 2};

        // TODO 一层层简化、但是为了看清脉络   默认从小到大
        //从小到大排序
        // 如果我们想忽略大小写排序，就传入String::compareToIgnoreCase，如果我们想倒序排序，就传入(s1, s2) -> -s1.compareTo(s2)，这个比较两个元素大小的算法就是策略。
//        Arrays.sort(arrInteger, new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1.intValue() > o2.intValue()){
//                    return -1;
//                }else if(o1.intValue() < o2.intValue()){
//                    return 1;
//                }
//                return 0;
//            }
//        });

//        Arrays.sort(arrInteger, (o1,o2) ->{
//            if(o1.intValue() > o2.intValue()){
//                return -1;
//            }else if(o1.intValue() < o2.intValue()){
//                return 1;
//            }
//            return 0;
//        });

        Arrays.sort(arrInteger, (o1, o2) -> o2.intValue()-o1.intValue());
        //Arrays.sort(arrInteger, Collections.reverseOrder());

        System.out.println(Arrays.toString(arrInteger));
    }

    public static void dyadicSort(){
        // 对二维数组进行排序  根据第一列降序、第二列升序
        int[][] testArr =  {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        Arrays.sort(testArr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for(int i = 0; i< testArr.length; i++){
            System.out.println(Arrays.toString(testArr[i]));
        }
    }

}
