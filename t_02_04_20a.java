package com.company.Cw;

import java.util.Scanner;

public class t_02_04_20a {
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
        double el = x;
        double y = el;
        int i = 1;
        do {
            el *= (-1) * x * x / (2 * i * (2 * i + 1));
            y += el;
            i++;
        } while (Math.abs(el) > eps);
        System.out.printf("y=in(x)=%s\n", y);
    }
}
