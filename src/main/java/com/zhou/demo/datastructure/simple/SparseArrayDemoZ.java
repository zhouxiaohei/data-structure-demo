package com.zhou.demo.datastructure.simple;

/**
 * @ClassName SparseArrayDemo
 * @Author JackZhou
 * @Date 2020/4/28  11:38
 * @desc    稀疏数组和二维数组     应用五子棋、围棋等棋盘保存
 *   博客说明  https://www.cnblogs.com/dwlovelife/p/11191444.html
 *   B站 韩顺平视频 7-9  稀疏数组
 **/
public class SparseArrayDemoZ {

    public static void main(String[] args) {
        toChessArr(toSparseArray(testOne()));
        //toChessArr(toSparseArray(testTwo()));
    }

    public static int[][] testTwo(){
        // 创建一个原始的二维数组 11 * 11
        int chessArr[][] = new int[8][11];
        chessArr[1][2] = 100;
        chessArr[1][8] = 188;
        chessArr[3][5] = 168;
        chessArr[3][10] = 200;
        chessArr[5][1] = 288;
        chessArr[5][10] = 188;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return chessArr;
    }

    public static int[][] testOne(){
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 黑子 2 白子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return chessArr;
    }


    /**
     * @Author JackZhou
     *  将二维数组转稀疏数组
     **/
    public static int[][] toSparseArray(int chessArr[][]){
        //先遍历二维数组,得到有值的总数量，用于初始化稀疏数组
        int len = chessArr.length;
        int wid = chessArr[0].length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 初始化稀疏数组、原始二维数组的长、宽、和总数量
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = len;
        sparseArr[0][1] = wid;
        sparseArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                if (chessArr[i][j] != 0) {
                    // 稀疏数组的一行的表示, 数据所在行、数据所在列、数据值
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        return sparseArr;
    }

    /**
      * @Author JackZhou
      * @Description  将稀疏数组转二维数组
     **/
    public static int[][] toChessArr(int sparseArr[][]) {

        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        return chessArr;
    }
}
