package com.algorithm.dynamic_programming.problem.medium;

/*link problem: https://leetcode.com/problems/jump-game-ii/*/
public class JumpGameII {
    private int nums[];

    public JumpGameII() {
        nums = new int[]{2,3,0,1,4};
        System.out.println(minJumpDynamicProgramming());
    }

    /**
     * Approach 1: Recursive
     */
    public int jumpRecursive() {
        return minJump(0);
    }

    public int minJump(int i) {
        if (i >= nums.length - 1)
            return 0;
        int jump = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + nums[i]; j++) {
            jump = Math.min(jump, 1 + minJump(j));
        }

        return jump;
    }

    /**
     * Approach 2: Dynamic Programming - Top Down
     * Time: n*(n-1)/2 --> O(n*n)
     * Space: O(n)
     *
     * Idea:
     * DP(i) is the min jump from j to i
     * DP(i) = Min(DP(i), DP(j)+1) if j+a(j) >= i
     */
    public int minJumpDynamicProgramming() {
        int n = nums.length;
        int DP[] = new int[n + 1];
        DP[0] = 0;
        for (int i = 1; i < n; i++) {
            DP[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    DP[i] = Math.min(DP[i], DP[j] + 1);
                }
            }
        }
        return DP[n - 1];
    }

    /**
     * Approach 3: Greedy com.algorithm
     * Time: O(n)
     */

}
