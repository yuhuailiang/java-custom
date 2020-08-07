package com.joinky.sorted;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Joinky
 * @date 2020-08-07
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 8, 10, 23, 11, 34, 22};
        bubbleSorted(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     * 1比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
    public static int[] bubbleSorted(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            /**
             * 从第一个元素开始遍历
             * 两两比较，前面元素小于后面元素则交换位置
             */
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
