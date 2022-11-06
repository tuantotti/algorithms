package com.algorithm.dynamic_programming.problem.easy;

import com.algorithm.dynamic_programming.ISolve;

import java.util.Arrays;
import java.util.List;

/*link problem: https://leetcode.com/problems/pascals-triangle/*/
public class PascalTriangle implements ISolve {
    private int n;

    public PascalTriangle(int n) {
        this.n = n;
    }

    @Override
    public int solve() {
        Integer a[][] = generate();
        return 0;
    }

    public Integer[][] generate() {
        Integer a[][];
        a = new Integer[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            a[i] = new Integer[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                }
            }
        }

        return a;
    }

    public List<Integer> get(int rowIndex) {
        n = rowIndex;
        Integer arr[][] = generate();
        return Arrays.asList(arr[rowIndex]);
    }

    @Override
    public void printProblem() {

    }
}
