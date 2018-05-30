package com.hc.java.day_16;

public class FullSortTest {

    private int array[];

    public FullSortTest(int array[]) {
        this.array = array;
    }

    /**
     * 递归输出全排列
     *
     * @param n 从第n个数开始全排列
     */
    public void fullSortByRecursion(int n) {
        if (n == array.length - 1) {
            print(array);
            return;
        }

        for (int i = n; i < array.length; i++) {
            // 去重
            if (!isSwap(array, n, i)) {
                continue;
            }
            swap(array, i, n);
            // 递归
            fullSortByRecursion(n + 1);
            swap(array, i, n);
        }
    }


    public void fullSortByIteration() {

        int length = array.length;

        // 全排前先排序
        quickSort(array, 0, length - 1);

        print(array);

        System.out.println("==========");

        while (true) {
            print(array);

            // 从右往左寻找相邻递增的两个数，把其中的第一个数作为"替换点"
            int index;
            for (index = length - 2; index >= 0; index--) {
                if (array[index] < array[index + 1]) {
                    break;
                }
            }

            if (index < 0) {
                break;
            }

            // 从右往左查找到第一个比"替换点"大的数
            int big;
            for (big = length - 1; big >= 0; big--) {
                if (array[big] > array[index]) {
                    swap(array, big, index);
                    break;
                }
            }

            // 倒转"替换点"后面的数
            reverse(array, index + 1, length - 1);
        }
    }

    /**
     * 判断start到end的区间内是否存在和end下标对应的数相等的数
     *
     * @param start
     * @param end
     * @return 如果存在和end对应的数相等的数，则返回false，否则返回true。
     */
    private boolean isSwap(int array[], int start, int end) {
        while (start < end) {
            if (array[start] == array[end]) {
                return false;
            }
            start++;
        }
        return true;
    }

    private void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void reverse(int array[], int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private void print(int array[]) {
        for (int a : array) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }

    private void print(int array[], int index[]) {
        for (int i : index) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }


    /**
     * 快排
     *
     * @param array
     * @param min
     * @param max
     */
    private void quickSort(int[] array, int min, int max) {
        if (min >= max) {
            return;
        }

        print(array);

        int middle = (max + min) / 2;


        int criterion = array[middle];
        //
        if (criterion > array[max]) {
            swap(array, middle, max);
        } else {
            criterion = array[max];
        }

        int start = min;
        int end = max - 1;

        while (start < end) {
            while (start < end && array[start] <= criterion) {
                start++;
            }
            while (start < end && array[end] >= criterion) {
                end--;
            }
            if (start < end) {
                swap(array, start, end);
            }
        }

        if (array[start] > array[max]) {
            swap(array, start, max);

            quickSort(array, min, start - 1);
            quickSort(array, start + 1, max);
        } else {

            quickSort(array, min, start);
            quickSort(array, start + 1, max);
        }

    }

    public static void main(String args[]) {
        FullSortTest sortTest = new FullSortTest(new int[]{4, 1, 5, 2, 3, 4});
        //sortTest.fullSortByRecursion(0);
        sortTest.fullSortByIteration();
    }

}
