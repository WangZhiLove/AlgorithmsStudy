package com.algorithms;


public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            merge(arr, start, middle);
            merge(arr, middle + 1, end);
            mergeSort(arr, start, middle, end);
        }
    }

    private static void mergeSort(int[] arr, int start, int middle, int end) {
        int leftLen = middle - start + 1;
        int rightLen = end - middle;
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[start + i];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = arr[middle + i + 1];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = start;
        while (leftIndex < leftLen && rightIndex < rightLen) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                arr[arrIndex++] = leftArr[leftIndex++];
            } else {
                arr[arrIndex++] = rightArr[rightIndex++];
            }
        }
        while (rightIndex < rightLen) {
            arr[arrIndex++] = rightArr[rightIndex++];
        }
        while (leftIndex < leftLen) {
            arr[arrIndex++] = leftArr[leftIndex++];
        }

    }

}


