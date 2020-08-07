package com.joinky.sorted;

import java.util.Arrays;

/**
 * 希尔排序
 * @author Joinky
 * @date 2020-08-07
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 8, 10, 23, 11, 34, 22};
        shellSorted(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     * @param arr
     * @return
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)
     */
    public static int[] shellSorted(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }
        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return arr;
    }
}
