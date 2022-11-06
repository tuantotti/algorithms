package com.algorithm.dynamic_programming.problem.medium;

import com.algorithm.dynamic_programming.ISolve;

/*link problem: https://leetcode.com/problems/longest-palindromic-substring/*/
public class LongestPalindromicSubstring implements ISolve {
    private String s;

    public LongestPalindromicSubstring() {
        s = "bababbdbababad";
        printProblem();
    }

    @Override
    public int solve() {
        return 0;
    }

    /**
     * Approach: Dynamic Programming
     * Time: O(n*n), Space: O(n*n)
     * Idea: DP(i,j) is the state of s[i] and s[j]
     * DP(i,j) = true if s[i]==s[j]
     * Base case: DP(j,j) = true,
     * --> DP(i,j) = (DP(i+1,j-1) && s[i]==s[j])
     *
     * @param s input string
     * @return the longest palindrome substring
     */
    public String longestPalindrome(String s) {
        int n = s.length();

        if (n == 2) return s.charAt(0) == s.charAt(1) ? s.substring(0, 2) : s.substring(0, 1);
        boolean DP[][] = new boolean[n][n];
        int maxLength = 1;
        int startIndex = 0;

        for (int j = 0; j < n; j++) {
            DP[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i == 1 || DP[i + 1][j - 1])) {
                    DP[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    //    Time: O(n*n), Space: O(1)
    public String optimizeSpace(String s) {
        return null;
    }

    /**
     * Approach: Manacher's Algorithm
     * Time: O(n)
     */
    public String ManacherAlgorithm(String s) {
        return null;
    }

    @Override
    public void printProblem() {
        System.out.println("Input: " + "n = " + s.length() + " [ " + s + "]");
        System.out.println("Output: " + longestPalindrome(s));
    }
}
