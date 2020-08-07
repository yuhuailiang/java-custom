package com.joinky.sorted;

import java.util.Arrays;

/**
 * @author Joinky
 * @date 2020-08-07
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 8, 10, 23, 11, 34, 22};
        quickSorted(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     * @return
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)
     */
    public static int[] quickSorted(int[] arr, int start, int end) {

        int length = arr.length;
        if (length < 1 || start < 0 || end >= length || start > end) {
            return null;
        }
        int smallIndex = partition(arr, start, end);
        if (smallIndex > start) {
            quickSorted(arr, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            quickSorted(arr, smallIndex + 1, end);
        }
        return arr;
    }

    public static int partition(int[] arr, int start, int end) {

        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(arr, pivot, end);
        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(arr, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换两个元素的位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
