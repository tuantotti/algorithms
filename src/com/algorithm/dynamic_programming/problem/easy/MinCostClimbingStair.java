package com.algorithm.dynamic_programming.problem.easy;

import com.algorithm.dynamic_programming.ISolve;

/*link problem: https://leetcode.com/problems/min-cost-climbing-stairs/*/
public class MinCostClimbingStair implements ISolve {
    private int arr[];

    public MinCostClimbingStair() {
        arr = new int[]{10, 15, 20};
    }

    @Override
    public int solve() {
        int n = arr.length;
        int dp[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + arr[i], dp[i - 2] + arr[i - 2]);
        }
        return dp[n];
    }

    @Override
    public void printProblem() {

    }
}
