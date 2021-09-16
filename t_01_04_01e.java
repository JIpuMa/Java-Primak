package com.company.Hw;

import java.util.Scanner;

public class t_01_04_01e {
    public void main() {
        System.out.print("x = ");
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        System.out.println("y = " + calc(x));
    }

    private double calc(double x) {
        return x * (1 + x * x * (1 + x * x));
    }
}
