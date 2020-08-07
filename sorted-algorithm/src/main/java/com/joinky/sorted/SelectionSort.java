package com.joinky.sorted;

import java.util.Arrays;

/**
 * @author Joinky
 * @date 2020-08-07
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 8, 10, 23, 11, 34, 22};
        selectedSorted(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序具体实现
     * @param arr
     * @return
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了
     * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     */
    public static int[] selectedSorted(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            /**
             * 找到最小数值，记录下标
             */
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
