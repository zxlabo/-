package com._02_算法._08_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 链接：https://leetcode.cn/problems/n-queens/
 *  本题思路：回溯
 *  1、边界处理
 *  2、对数据进行初始化
 *  3、开始调用回溯算法，并传入初始值
 *  回溯算法：
 *      1）结束递归，把数据加入到集合
 *      2）开启for循环，依次执行每个选择。
 *      3）判断当前值是否可用
 *      4）继续调用回溯算法
 *      5）还原现场
 *  4、返回结果
 */
class _51N皇后 {
    public static void main(String[] args) {
        _51N皇后 n皇后 = new _51N皇后();
        n皇后.solveNQueens(4);
    }
    //1、创建数组 colsQueue：每一行存储皇后的是哪一列；
    // 索引是行，值是：当前行哪一列存储皇后
    private int[] colsQueue;
    //2、queue：索引是列，作用是判断：当前列是否存储皇后
    private boolean[] queue;//当前列是否存储皇后
    /**
     * 3、leftTop 左上角->右下角是否存储皇后
     * leftTop 索引怎么计算？从右上角开始认为是0，到左下角。
     * leftTop len=(n<<1)-1; ltIndex = row-col+n-1
     */
    private boolean[] leftTop;
    /**
     * 4、rightTop 右上角->左下角是否存储皇后
     * rightTop 索引怎么计算？从左上角认为是0
     * rtIndex = row+col
     */
    private boolean[] rightTop;
    //5、存储皇后的list
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        //1、边界处理
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("Q");
            result.add(list);
            return result;
        }
        //2、对数组初始化
        colsQueue = new int[n];
        queue = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[(n << 1) - 1];
        //3、本题采用回溯算法,从0行开始
        addQueue(0);
        //4、返回结果
        return result;
    }

    private void addQueue(int row) {
        if (row == colsQueue.length) {
            //说明到最后一行了
            addMsg();
            return;
        }
        for (int col = 0; col < colsQueue.length; col++) {
            //判断当前列是不是可以插入皇后
            if (queue[col]) continue;
            //左上角对角线
            int ltIndex = row - col + colsQueue.length - 1;
            if (leftTop[ltIndex]) continue;
            //右上角对角线
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;
            //当前列选择了皇后
            colsQueue[row] = col;
            queue[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            //继续调用回溯算法
            addQueue(row + 1);
            //还原现场
            queue[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    /**
     * 将字符串添加到list中
     */
    private void addMsg() {
        List<String> list = new ArrayList();
        for (int i = 0; i < colsQueue.length; i++) {
            //第i行第col列有皇后
            int col = colsQueue[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colsQueue.length; j++) {
                if (j == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        result.add(list);
    }

}