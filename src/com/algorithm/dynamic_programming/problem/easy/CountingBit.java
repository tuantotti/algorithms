package com.algorithm.dynamic_programming.problem.easy;

/*link problem: https://leetcode.com/problems/counting-bits/*/
public class CountingBit {
    /*O(n*n)*/
    public int[] countBits(int n) {
        int ins[] = new int[n + 1];
        if (n == 0)
            return ins;
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if (j % 2 == 1) {
                    ins[i]++;
                }
                j /= 2;
            }
        }

        return ins;
    }

    /*O(n)*/
    public int[] countBitsOptimize(int n) {
        int rs[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rs[i] = rs[i / 2] + (i % 2);
        }

        return rs;
    }
}
