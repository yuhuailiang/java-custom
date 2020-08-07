package com.joinky.sorted;

import java.util.Arrays;

/**
 * @author Joinky
 * @date 2020-08-07
 * 归并排序
 */
public class MergeSort {

    private static int[] auk;

    public static void main(String[] args) {

        int[] array = new int[]{34,53,33,65,23,75,33,6,12,64};
        auk = new int[array.length];
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param array
     * @param low
     * @param high
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     */
    public static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high - 1) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            auk[k] = array[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = auk[j];
                j++;
            } else if (j > high) {
                array[k] = auk[i];
                i++;
            } else if (auk[i] < auk[j]) {
                array[k] = auk[i];
                i++;
            } else {
                array[k] = auk[j];
                j++;
            }
        }
    }
}
