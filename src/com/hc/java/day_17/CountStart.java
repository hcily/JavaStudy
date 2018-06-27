package com.hc.java.day_17;

import java.util.Scanner;

public class CountStart {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] starts = new int[n][2];
        int flag = 0;
        for (int i = 0; i < n * 2; i++) {
            int point = scanner.nextInt();
            starts[i / 2][flag] = point;
            flag++;
            if (flag == 2) {
                flag = 0;
            }
        }
        int m = scanner.nextInt();
        int[][] rectangles = new int[m][4];
        flag = 0;
        for (int i = 0; i < m * 4; i++) {
            int point = scanner.nextInt();
            rectangles[i / 4][flag] = point;
            flag++;
            if (flag == 4) {
                flag = 0;
            }
        }
        scanner.close();

        for (int[] rectangle : rectangles) {
            int count = 0;
            for (int[] start : starts) {
                if (start[0] >= rectangle[0] && start[0] <= rectangle[2]
                        && start[1] >= rectangle[1] && start[1] <= rectangle[3]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
