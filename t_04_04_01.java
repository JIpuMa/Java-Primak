package com.company.Cw;

import java.util.Objects;
import java.util.Scanner;

public class t_04_04_01 {
    public void main() {
        System.out.print("k(number of polynomials): ");
        Scanner sc_k = new Scanner(System.in);
        int k = sc_k.nextInt();
        System.out.print("n(number of max degree): ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt() + 1;
        int[][][] arr = new int[k][n][2];
        for (int i = 0; i < k; i++) {
            System.out.println("Polynomial " + (i + 1));
            arr[i] = create_polynomial(new int[n][2]);
        }
        int[][][] new_arr = Polynomial.addNextPols(arr);
        print_polynomial(new_arr[new_arr.length - 1]);
    }

    public int[][] create_polynomial(int[][] pol) {
        for (int i = 0; i < pol.length; i++) {
            System.out.println("Coefficient near x" + i + " (m/n)");
            System.out.print("m: ");
            Scanner sc_num = new Scanner(System.in);
            int num = sc_num.nextInt();
            System.out.print("n: ");
            Scanner sc_den = new Scanner(System.in);
            int den = sc_den.nextInt();
            RationalFractionForPol obj = new RationalFractionForPol(num, den);
            pol[i] = obj.getRF();
        }
        return pol;
    }

    public void print_polynomial(int[][] pol) {
        for (int i = 0; i < pol.length; i++) {
            System.out.printf("(%s/%s)*x^(%d)", pol[i][0], pol[i][1], i);
            if (i != pol.length - 1) {
                System.out.print(" + ");
            }
        }
    }
}

class Polynomial {
    private int[][] coef;

    public Polynomial() {
    }

    public Polynomial(int[][] coef) {
        setPolynomial(coef);
    }

    public void setPolynomial(int[][] coef) {
        for (int i = 0; i < coef.length; i++) {
            this.coef[i] = coef[i];
        }
    }

    public int[][] getPolynomial() {
        return coef;
    }

    public static int[][] addPols(int[][] cf1, int[][] cf2) {
        int l;
        if (cf1.length > cf2.length) {
            l = cf1.length;
        } else {
            l = cf2.length;
        }
        int[][] ans = new int[l][2];
        for (int i = 0; i < l; i++) {
            if ((cf1[i] == null) & (cf2[i] == null)) {
                ans[i] = new int[]{0, 0};
            } else if ((cf1[i] == null) & (cf2[i] != null)) {
                ans[i] = cf2[i];
            } else if ((cf1[i] != null) & (cf2[i] == null)) {
                ans[i] = cf1[i];
            } else if ((cf1[i] != null) & (cf2[i] != null)) {
                ans[i] = RationalFractionForPol.add(cf1[i], cf2[i]);
            }
        }
        return ans;
    }

    public static int[][][] addNextPols(int[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                arr[i] = arr[i - 1];
            } else if (i == 0) {
                arr[i] = addPols(arr[i], arr[i + 1]);
            } else {
                arr[i] = addPols(arr[i - 1], arr[i + 1]);
            }
        }
        return arr;
    }
}


class RationalFractionForPol {
    private int[] rf = {0, 0};

    public RationalFractionForPol(int[] rf) {
        this.rf = rf;
    }

    public RationalFractionForPol(int num, int den) {
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
        int gcd = UtilForPol.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
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
        int gcd = UtilForPol.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
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
        int gcd = UtilForPol.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
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
        int gcd = UtilForPol.gcd(Math.abs(ans[0]), Math.abs(ans[1]));
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

class UtilForPol {
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
