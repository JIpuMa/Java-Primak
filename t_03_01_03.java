package com.company.Cw;

import java.util.Scanner;

public class t_03_01_03 {
    public void main() {
        System.out.print("n: ");
        Scanner sc_n = new Scanner(System.in);
        int n = sc_n.nextInt();
        double[] arr = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Input element " + i + ": ");
            Scanner sc_d = new Scanner(System.in);
            double el = sc_d.nextDouble();
            arr[i] = el;
            sum += el;
        }
        double mean = sum/n;
        double std = 0;
        for (double el: arr) {
            std += Math.pow(el - mean, 2);
        }
        System.out.println("Mean: " + mean);
        System.out.println("Std: " + Math.sqrt(std/n));
    }
}
