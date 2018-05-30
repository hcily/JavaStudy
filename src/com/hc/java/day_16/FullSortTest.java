package com.hc.java.day_16;

public class FullSortTest {

    private int array[];

    public FullSortTest(int array[]) {
        this.array = array;
    }

    public void fullSortByRecursion(int n) {
        if (n == array.length - 1) {
            print();
            return;
        }

        for (int i = n; i < array.length; i++) {
            // 去重
            if (!isSwap(n, i)) {
                continue;
            }
            swap(i, n);
            // 递归
            fullSortByRecursion(n + 1);
            swap(i, n);
        }
    }

    private boolean isSwap(int start, int end) {
        while (start < end) {
            if (array[start] == array[end]) {
                return false;
            }
            start++;
        }
        return true;
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void print() {
        for (int a : array) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        FullSortTest sortTest = new FullSortTest(new int[]{1, 2, 2, 4, 4});
        sortTest.fullSortByRecursion(0);
    }

}
