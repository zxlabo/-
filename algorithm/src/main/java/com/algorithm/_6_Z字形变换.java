package com.algorithm;

class _6_Z字形变换 {

    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 4);
//        "PINALSIGYAHRPI"
        System.out.println(s);
    }

    public static String convert(String s, int numRows) {
        //1、进行安全边界校验
        /**
         * 思路：找规律
         * 开始间隔 int dis=2*(numRows-2)
         * 遍历，给每一行赋值
         * 行为n：初始值为n，间隔为 dis-2n 所以：n + (dis-2n)*j j从0开始
         * 最后一行：
         */
        char[] ch = s.toCharArray();
        char[] res = new char[ch.length];
        int temp = 2 * (numRows - 1);
        int i = 0;
        for (int n = 0; n < numRows; n++) {
            int dis;
            int pos = n;
            if (n == numRows - 1) {
                dis = temp;
            } else {
                dis = temp - 2 * n;
            }
            while (i < ch.length&&pos < ch.length) {
                char ch1 = ch[pos];
                res[i] = ch1;
                i++;
                pos = pos + dis;
            }
        }
        return new String(res);
    }

}