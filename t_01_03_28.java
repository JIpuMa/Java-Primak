package com.company.Hw;

import java.util.Scanner;

public class t_01_03_28 {
    public void main() {
        System.out.print("r = ");
        Scanner sc1 = new Scanner(System.in);
        double r = sc1.nextDouble();
        System.out.print("R = ");
        Scanner sc2 = new Scanner(System.in);
        double R = sc2.nextDouble();
        double V = 2 * R * Math.pow(Math.PI * r, 2);
        System.out.println("V = " + V);
    }
}
