package com._00_必会;

import java.util.Arrays;

/**
 * author : Naruto
 * date   : 2022/5/16
 * desc   :
 * version:
 */
class _0_数组必会 {
    public static void main(String[] args) {
        _0_数组必会 test = new _0_数组必会();
        //1、整数反转
        System.out.println(test.reverse(-123));
        //2、逆序对[3,9]
        int[] res = test.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        System.out.println(Arrays.toString(res));
    }

    /**
     * 1、整数反转
     * 考点：
     * 1、整数反转
     * 2、数组越界
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int v = x % 10;
            int temp = result;
            result = 10 * result + v;
            //判断是否越界，倒回去运算
            if ((result - v) / 10 != temp) {
                return 0;
            }
            x = x / 10;
        }
        return result;
    }

    /**
     * 2、找逆序对
     */
    public int[] subSort(int[] array) {
        //1、边界判断
        if (array == null || array.length < 2) {
            return new int[2];
        }
        //2、从左边开始找右逆序对
        int right = -1;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else {
                right = i;
            }
        }
        //3、从右边开始找左逆序对
        int left = -1;
        int min = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] < min) {
                min = array[i];
            } else {
                left = i;
            }
        }
        return new int[]{left,right};
    }

}
