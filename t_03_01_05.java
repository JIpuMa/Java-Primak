package com.company.Cw;

import java.util.Scanner;

public class t_03_01_05 {
    public void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);
        System.out.print("n: ");
        Scanner sc_n = new Scanner(System.in);
        double min = Double.POSITIVE_INFINITY;
        int n = sc_n.nextInt();
        double[] ans = new double[3];
        double[] A = {x, y, z};
        double[][] Ai = new double[n][3];
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d: ", i);
            Scanner sc_x = new Scanner(System.in);
            double xi = sc_x.nextDouble();
            Ai[i][0] = xi;
            System.out.printf("y%d: ", i);
            Scanner sc_y = new Scanner(System.in);
            double yi = sc_y.nextDouble();
            Ai[i][1] = yi;
            System.out.printf("z%d: ", i);
            Scanner sc_z = new Scanner(System.in);
            double zi = sc_z.nextDouble();
            Ai[i][2] = zi;
            double len_AAi = calc_len(A, Ai[i]);
            if (len_AAi < min) {
                min = len_AAi;
                ans = Ai[i];
            }
        }
        System.out.printf("xi=%.2f; yi=%.2f; zi=%.2f\n", ans[0], ans[1], ans[2]);
    }

    double calc_len(double[] A, double[] B) {
        return Math.pow((Math.pow(A[0] - B[0], 2) + Math.pow(A[1] - B[1], 2) + Math.pow(A[2] - B[2], 2)), 0.5);
    }
}
