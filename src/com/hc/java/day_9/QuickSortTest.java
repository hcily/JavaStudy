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
		int flag = a[min];

		while (left < right) {
			while (a[right] >= flag && left < right) {
				right--;
			}

			while (a[left] <= flag && left < right) {
				left++;
			}

			if (left < right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
			}
		}

		a[min] = a[left];
		a[left] = flag;

		sort(a, min, left - 1);
		sort(a, left + 1, max);
	}

	public void sort2(int a[], int min, int max) {
		if (min >= max) {
			return;
		}
		int left = min;
		int right = max;
		int middle = (right - left) / 2 + left;
		int pivot = a[middle];

		while (left < right) {
			while (a[right] >= pivot && left < right) {
				right--;
			}
			

			while (a[left] <= pivot && left < right) {
				left++;
			}
			
			if (left < right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
			}
		}

		a[middle] = a[left];
		a[left] = pivot;

		sort2(a, min, left-1);
		sort2(a, left + 1, max);
	}

	public static void main(String[] args) {
		int a[] = new int[] { 12, 12, 34, 35, 23, 67, 2, 4, 98, 43, 2, 5 };
		// 2, 12, 4, 12, 23, 67, 35, 34, 98, 43
		QuickSortTest quickSortTest = new QuickSortTest();
		quickSortTest.sort2(a, 0, a.length - 1);
		print(a);
	}

	public static void print(int a[]) {
		for (int i : a) {
			System.out.print("," + i);
		}
	}
}
