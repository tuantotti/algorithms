package com.algorithm.dynamic_programming.problem.easy;

import com.algorithm.dynamic_programming.ISolve;

import java.util.Arrays;

/*note: để tìm chuỗi con tăng dài nhất --> chia thành bài toán nhỏ với chuỗi nhỏ hơn
 * bài toán nhỏ nhất là khi chuỗi độ dài bằng 1 --> return 1
 * bài toán lớn hơn Si = max{Sj + 1 | j<i && aj<ai}*/
public class LongestIncreasingSubsequence implements ISolve {
    private int arr[];

    public LongestIncreasingSubsequence() {
        arr = new int[]{1, 6, 7, 8, 2, 6, 9, 20, 11, 14, 15, 2};
        printProblem();
    }

    /*
     * Phân chia:
     * + Ký hiệu Pi là bài toán tìm dãy con cực đại mà phần tử cuối cùng là ai, với mọi i = 1,…, n
     * + Ký hiệu Si là số phần tử của lời giải của Pi, với mọi i = 1,…, n
     * + S1 = 0
     * + Si = max{0, max{Sj +1| j < i && aj < ai}}
     * + Số phần tử của dãy con cực đại của bài toán xuất phát là max{S1, S2, …, Sn}
     * */

    /**
     * link problem: https://leetcode.com/problems/longest-increasing-subsequence/
     *
     * @return the longest increasing subsequence
     */
    @Override
    public int solve() {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int rs = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            rs = Math.max(rs, dp[i]);
        }

        return rs;
    }

    @Override
    public void printProblem() {
        System.out.print("Input: " + "n = " + arr.length + " [ ");
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println("]");
        int result = solve();
        System.out.println("Max Subsequence: " + result);
    }
}
