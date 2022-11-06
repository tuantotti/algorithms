package com.algorithm.dynamic_programming.problem.medium;

import com.algorithm.dynamic_programming.ISolve;

/*link problem: https://leetcode.com/problems/maximum-subarray/*/
public class MaximumSubarray implements ISolve {
    private int nums[];

    public MaximumSubarray() {
        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solve());
    }

    @Override
    public int solve() {
        int n = nums.length;
        int DP[] = new int[n + 1];
        DP[0] = nums[0];
        int rs = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            DP[i] = Math.max(nums[i], DP[i - 1] + nums[i]);
            rs = Math.max(rs, DP[i]);
        }
        return rs;
    }

    @Override
    public void printProblem() {

    }
}
