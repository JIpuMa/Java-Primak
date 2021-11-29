package com.company.Cw;

import java.lang.Math;
import java.util.Objects;
import java.util.Scanner;

public class t_04_03_01 {
    public void main() {
        System.out.print("k: ");
        Scanner sc_k = new Scanner(System.in);
        int k = sc_k.nextInt();
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            System.out.println("Rational fraction " + (i + 1) + " (m/n)");
            System.out.print("m: ");
            Scanner sc_num = new Scanner(System.in);
            int num = sc_num.nextInt();
            System.out.print("n: ");
            Scanner sc_den = new Scanner(System.in);
            int den = sc_den.nextInt();
            RationalFraction obj = new RationalFraction(num, den);
            arr[i] = obj.getRF();
        }
        int[][] new_arr = RationalFraction.addNext(arr);
        System.out.println("Sum of array: " + new_arr[new_arr.length - 1][0] + "/" + new_arr[new_arr.length - 1][1]);
    }
}


class RationalFraction {
    private int[] rf = {0, 0};

    public RationalFraction(int[] rf) {
        this.rf = rf;
    }

    public RationalFraction(int num, int den) {
        setRF(num, den);
    }

    public void setRF(int num, int den) {
        this.rf[0] = num;
        this.rf[1] = den;
    }

    public int[] getRF() {
        return rf;
    }

    public static int[] add(int[] rf1, int[] rf2) {
        int num1 = rf1[0];
        int den1 = rf1[1];
        int num2 = rf2[0];
        int den2 = rf2[1];
        int[] ans = new int[2];
        if (Objects.equals(den1, den2)) {
            ans[0] = num1 + num2;
            ans[1] = den1;
        } else {
            ans[0] = num1 * den2 + num2 * den1;
            ans[1] = den1 * den2;
        }
        if ((ans[0] < 0) & (ans[1] < 0)) {
            ans[0] = Math.abs(ans[0]);
            ans[1] = Math.abs(ans[1]);
        }
        int gcd = Util.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
        if (gcd != 1) {
            ans[0] /= gcd;
            ans[1] /= gcd;
        }
        return ans;
    }

    public static int[] sub(int[] rf1, int[] rf2) {
        int num1 = rf1[0];
        int den1 = rf1[1];
        int num2 = rf2[0];
        int den2 = rf2[1];
        int[] ans = new int[2];
        if (Objects.equals(den1, den2)) {
            ans[0] = num1 - num2;
            ans[1] = den1;
        } else {
            ans[0] = num1 * den2 - num2 * den1;
            ans[1] = den1 * den2;
        }
        if ((ans[0] < 0) & (ans[1] < 0)) {
            ans[0] = Math.abs(ans[0]);
            ans[1] = Math.abs(ans[1]);
        }
        int gcd = Util.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
        if (gcd != 1) {
            ans[0] /= gcd;
            ans[1] /= gcd;
        }
        return ans;
    }

    public static int[] mul(int[] rf1, int[] rf2) {
        int num1 = rf1[0];
        int den1 = rf1[1];
        int num2 = rf2[0];
        int den2 = rf2[1];
        int[] ans = new int[2];
        ans[0] = num1 * num2;
        ans[1] = den1 * den2;
        if ((ans[0] < 0) & (ans[1] < 0)) {
            ans[0] = Math.abs(ans[0]);
            ans[1] = Math.abs(ans[1]);
        }
        int gcd = Util.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
        if (gcd != 1) {
            ans[0] /= gcd;
            ans[1] /= gcd;
        }
        return ans;
    }

    public static int[] div(int[] rf1, int[] rf2) {
        int num1 = rf1[0];
        int den1 = rf1[1];
        int num2 = rf2[0];
        int den2 = rf2[1];
        int[] ans = new int[2];
        ans[0] = num1 * den2;
        ans[1] = den1 * num2;
        if ((ans[0] < 0) & (ans[1] < 0)) {
            ans[0] = Math.abs(ans[0]);
            ans[1] = Math.abs(ans[1]);
        }
        int gcd = Util.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
        if (gcd != 1) {
            ans[0] /= gcd;
            ans[1] /= gcd;
        }
        return ans;
    }

    public static int[][] addNext(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                arr[i] = arr[i - 1];
            } else if (i == 0) {
                arr[i] = add(arr[i], arr[i + 1]);
            } else {
                arr[i] = add(arr[i - 1], arr[i + 1]);
            }
        }
        return arr;
    }
}

class Util {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
