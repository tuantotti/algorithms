package com.algorithm.dynamic_programming.problem.medium;

import com.algorithm.dynamic_programming.ISolve;

import java.util.Arrays;

/*
* Bài toán dãy con chung dài nhất
Ký hiệu X = {X1, X2, …, Xn}, một dãy con của X là dãy được tạo ra bằng việc loại bỏ
1 số phần tử nào đó của X đi
Đầu vào: Cho 2 dãy X = {X1, X2, …, Xn} và Y = {Y1, Y2, …, Ym}
Đầu ra: Tìm dãy con chung của X và Y có độ dài lớn nhất
* */
public class LongestCommonSubsequence implements ISolve {
    private int X[];
    private int Y[];

    public LongestCommonSubsequence() {
        X = new int[]{3, 7, 2, 5, 1, 4, 9};
        Y = new int[]{4, 3, 2, 6, 1, 5, 4, 9, 7};
        printProblem();
    }

    @Override
    public int solve() {
        int n = X.length;
        int m = Y.length;
        int S[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (X[i - 1] == Y[j - 1]) S[i][j] = S[i - 1][j - 1] + 1;
                else S[i][j] = Math.max(S[i][j - 1], S[i - 1][j]);
            }
        }
        return S[n][m];
    }

    @Override
    public void printProblem() {
        System.out.print("Input: " + "n = " + X.length + " [ ");
        Arrays.stream(X).forEach(i -> System.out.print(i + " "));
        System.out.println("]");

        System.out.print("Input: " + "m = " + Y.length + " [ ");
        Arrays.stream(Y).forEach(i -> System.out.print(i + " "));
        System.out.println("]");

        int result = solve();
        System.out.println("Longest Common Subsequence: " + result);
    }

    public void printLongestCommonSubsequence() {

    }

}
