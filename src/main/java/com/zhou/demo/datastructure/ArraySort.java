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
        selfSort();

//        System.out.println( 1==1 ?  1 : 2);
//        System.out.println( 1==2 ?  1 : 2);
    }


    public static void simpleSort() {
        int[] arrInt = {1, 3, 4, 2, 5, 2};
        //从小到大排序
        Arrays.sort(arrInt);
        //从  到 排序
        //Arrays.sort(arrInt, 0, 3);
        System.out.println(Arrays.toString(arrInt)); // [1, 2, 2, 3, 4, 5]

        char[] arrChar = {'c', 'a','3', 'z', '1','d', '4', 'c', 'b'};
        Arrays.sort(arrChar);
        System.out.println(Arrays.toString(arrChar)); //[1, 3, 4, a, b, c, c, d, z]
    }


    //public static <T> void sort(T[] a,int fromIndex, int toIndex, Comparator<? super T> c)
    // 如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值， 这样颠倒一下，就可以实现反向排序了
    public static void selfSort(){
        //TODO 对基本类型反序  Collections.reverseOrder()   不然要转换成引用类型
        int[] arrInt = {1, 3, 4, 2, 5, 2};
        //System.out.println(Arrays.sort(arrInt, Collections.reverseOrder()));

        Integer[] arrInteger = {1, 3, 4, 2, 5, 2};
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

        Arrays.sort(arrInteger, (o1,o2) ->{
            if(o1.intValue() > o2.intValue()){
                return -1;
            }else if(o1.intValue() < o2.intValue()){
                return 1;
            }
            return 0;
        });

        System.out.println(Arrays.toString(arrInteger));

        int[][] testArr =  {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        Arrays.sort(testArr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
       for(int i = 0; i< testArr.length; i++){
           System.out.println(Arrays.toString(testArr[i]));
       }
    }




}
