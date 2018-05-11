package com.hc.java.day_9;

/**
 * @author cathcool
 * @version 创建时间：2018年5月11日 下午6:53:45 快速排序
 */
public class QuickSortTest {

	public void sort(int[] a, int min, int max) {
		if (min >= max) {
			return;
		}

		int left = min;
		int right = max;
		int flag = a[(right - left) / 2 + left];

		while (left < right) {
			if (a[left] < flag) {
				left++;
				continue;
			}
			if (a[right] > flag) {
				right--;
				continue;
			}
			int temp = a[left];
			a[left] = a[right];
			a[right] = temp;
		}

		int middle = left;
		if (a[middle] < flag) {
			sort(a, min, middle);
			sort(a, middle + 1, max);
		} else {
			sort(a, min, middle - 1);
			sort(a, middle, max);
		}
	}

	public static void main(String[] args) {
		int a[] = new int[] { 12, 12, 34, 35, 23, 67, 2, 4, 98, 43 };
		QuickSortTest quickSortTest = new QuickSortTest();
		quickSortTest.sort(a, 0, a.length-1);
		print(a);
	}

	public static void print(int a[]) {
		for (int i : a) {
			System.out.print("," + i);
		}
	}
}
