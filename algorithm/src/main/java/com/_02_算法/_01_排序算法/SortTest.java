package com._02_算法._01_排序算法;

import com._02_算法.helper.tools.Asserts;
import com._02_算法.helper.tools.Integers;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class SortTest {

    public static void main(String[] args) {
        Integer[] array = {79, 80, 94, 43, 79, 40, 40, 40, 40};
        System.out.println("原始数组"+Arrays.toString(array));
        testSorts(array,
                new _01_冒泡排序(),
//				new _09_基数排序()
//				new _04_插入排序(),
//				new InsertionSort2(),
//				new InsertionSort3(),
				new _02_选择排序()
//                ,new _03_堆排序()
//				new _05_归并排序(),
//				new _01_冒泡排序(),
//				new _06_快速排序(),
//				new _07_希尔排序()
        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

}
