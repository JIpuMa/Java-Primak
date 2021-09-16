package com.company.Cw;

import java.util.Scanner;

public class t_01_03_07 {
    public void main() {
        double F;
        double y = 6.673 * Math.pow(10, -11);
        System.out.print("m1 = ");
        Scanner sc1 = new Scanner(System.in);
        double m1 = sc1.nextDouble();
        System.out.print("m2 = ");
        Scanner sc2 = new Scanner(System.in);
        double m2 = sc2.nextDouble();
        System.out.print("r = ");
        Scanner sc3 = new Scanner(System.in);
        double r = sc3.nextDouble();
        F = (y * m1 * m2) / (r * r);
        System.out.printf("F = %e", F);
    }
}
