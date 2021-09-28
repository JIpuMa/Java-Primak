package com.company.Hw;

import java.util.Scanner;

public class t_02_04_20d {
    public void main() {
        double eps = -1;
        do {
            System.out.print("Input e(e>0): ");
            Scanner sc = new Scanner(System.in);
            eps = sc.nextDouble();
        } while (eps <= 0);
        System.out.print("Input x: ");
        Scanner sc_x = new Scanner(System.in);
        double x = sc_x.nextDouble();
        double el = 1.0;
        double y = el;
        int i = 1;
        do {
            el *= x / i;
            y += el;
            i++;
        } while (Math.abs(el) > eps);
        System.out.printf("y=e^x=%s\n", y);
    }
}
