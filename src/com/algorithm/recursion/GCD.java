package com.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Greatest Common Divisor
 */
public class GCD {
    private int x, y;

    public GCD() {
    }

    public GCD(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int gcdMinus(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }

    public int gcdMinusRecursion(int a, int b) {
        if (a == b) return a;
        if (a > b)
            a = a - b;
        else
            b = b - a;

        return gcdMinusRecursion(a, b);
    }

    public int gcdEuclid(int a, int b) {
        if (b == 0) return a;

        return gcdEuclid(b, a % b);
    }

    public int gcdExtendedEuclid(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int gcd = gcdExtendedEuclid(b, a % b);
        int temp = x;
        x = y;
        y = temp - a / b * y;
        return gcd;
    }

    public int invertModulo(int a, int m) {
        int gcd = gcdExtendedEuclid(a, m);
        if (gcd != 1) {
            return -1;
        }

        return (x % m + m) % m;
    }

    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> phanTichSoNguyen(int n) {
        int i = 2;
        List<Integer> listNumbers = new ArrayList<>();
        while (n > 1) {
            if (n % i == 0) {
                n = n / i;
                listNumbers.add(i);
            } else {
                i++;
            }
        }
        if (listNumbers.isEmpty()) {
            listNumbers.add(n);
        }
        return listNumbers;
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        int a = 1071, b = 462;
        int result = gcd.gcdMinusRecursion(a, b);
        System.out.println("gcdMinusRecursion: gcd(" + a + "," + b + ") = " + result);
        result = gcd.gcdMinus(a, b);
        System.out.println("gcdMinus: gcd(" + a + "," + b + ") = " + result);
        result = gcd.gcdEuclid(a, b);
        System.out.println("gcdEuclid: gcd(" + a + "," + b + ") = " + result);

        System.out.println("=============================================");
        a = 7;
        b = 17;
        result = gcd.gcdExtendedEuclid(a, b);
        System.out.println("gcdExtendedEuclid: gcd(" + a + "," + b + ") = " + result);
        System.out.println("x=" + gcd.getX() + ", y=" + gcd.getY());
        System.out.println("invert of x followed by modulo y: " + gcd.invertModulo(a, b));

        List<Integer> integers = phanTichSoNguyen(119);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
