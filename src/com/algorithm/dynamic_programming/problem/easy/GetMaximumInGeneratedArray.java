package com.algorithm.dynamic_programming.problem.easy;

/*link problem: https://leetcode.com/problems/get-maximum-in-generated-array/*/
public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        int arr[] = new int[n + 1];
        if (n == 0) return 0;
        if (n == 1) return 1;

        arr[0] = 0;
        arr[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) arr[i] = arr[i / 2];
            if (i % 2 == 1) arr[i] = arr[i / 2] + arr[i / 2 + 1];

            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
