package com.algorithm.dynamic_programming.problem.easy;

import com.algorithm.dynamic_programming.ISolve;

import java.util.Arrays;

/*link problem: https://leetcode.com/problems/maximum-subarray/*/
public class MaximumSubArray implements ISolve {
    private int arr[];

    public MaximumSubArray() {
        arr = new int[]{90, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solve());
    }

    /*
     * S1 = a1
     * Si = max(S(i-1) + a(i-1), a(i-1))
     * */
    @Override
    public int solve() {
        int n = arr.length;
        int S[] = new int[n];
        S[0] = arr[0];
        int rs = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            S[i] = Math.max(S[i - 1] + arr[i], arr[i]);
            rs = Math.max(rs, S[i]);
        }
        return rs;
    }

    @Override
    public void printProblem() {
        System.out.print("Input: ");
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
        int result = solve();
        System.out.println("Max Subsequence: " + result);
    }
}
