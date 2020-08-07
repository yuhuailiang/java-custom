package com.joinky.sorted;

import java.util.Arrays;

/**
 * 插入排序
 * @author Joinky
 * @date 2020-08-07
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 8, 10, 23, 11, 34, 22};
        insertSorted(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     * @return
     * 1从第一个元素开始，该元素可以认为已经被排序；
     * 2取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5将新元素插入到该位置后；
     * 重复步骤2~5。
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
    public static int[] insertSorted(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex --;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
