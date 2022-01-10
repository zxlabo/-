package com.algorithm;

class _50_n次幂 {
    public static void main(String[] args) {
        System.out.println(myPow2(2, -3));
    }

    /**
     * 非递归：快速幂
     */
    public static double myPow2(double x, int n) {
        long num = Math.abs((long) n);
        double res = 1;
        double temp = x;
        /**
         * 十进制转成二进制
         * 方法：n&1，然后n>>1
         */
        while (num > 0) {
            if ((num & 1) == 1) {
                res *= temp;
            }
            temp *= temp;
            num = num >> 1;
        }
        if (n < 0) {
            return 1 / res;
        } else {
            return res;
        }
    }

    /**
     * 递归求 x的n次幂
     */
    public static double myPow(double x, int n) {
        long rN = Math.abs((long) n);
        double res = pow(x, rN);
        if (n > 0) {
            return res;
        } else {
            return 1 / res;
        }
    }

    public static double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = pow(x, n >> 1);
        half *= half;
        return ((n & 1) == 0 ? half : half * x);
    }

}