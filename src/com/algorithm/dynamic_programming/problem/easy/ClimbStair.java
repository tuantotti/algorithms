package com.algorithm.dynamic_programming.problem.easy;

import com.algorithm.dynamic_programming.ISolve;

/*link problem: https://leetcode.com/problems/climbing-stairs/*/
public class ClimbStair implements ISolve {

    private int n;

    public ClimbStair() {
        n = 5;
        printProblem();
    }

    @Override
    public int solve() {
        int a1 = 1;
        int a2 = 2;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int an = a1 + a2;
        for (int i = 3; i < n; i++) {
            a1 = a2;
            a2 = an;
            an = a1 + a2;
        }
        return an;
    }

    @Override
    public void printProblem() {
        int result = recursion(n);
        int result1 = solve();
        System.out.println("Steps for n = " + n + " is " + result + " steps");
        System.out.println("Steps for n = " + n + " is " + result1 + " steps using dynamic programming");
    }

    public int recursion(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return recursion(n - 1) + recursion(n - 2);
    }
}
