package com.排序算法;

import com.算法.helper.tools.Asserts;
import com.算法.helper.tools.Integers;

/**
 * author : Naruto
 * date   : 2022/5/3
 * desc   :
 * version:
 */
class SortTest {
    public static void main(String[] args) {
//        Integer[] array = {79, 80, 94, 43, 79, 40, 40, 40, 40,94,94,94};
        Integer[] array = {7,3,5,8,6,7,4,5,-1};
//        Integer[] array = Integers.random(100, 1, 1000);
        _计数排序 sort = new _计数排序();
        sort.sort(array);
        System.out.println("排序结果"+Integers.isAscOrder(array));
        Integers.println(array);
    }
}
