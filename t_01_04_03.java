package com.company.Cw;

import java.util.Scanner;

public class t_01_04_03 {
    public void main() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Nums: ");
            Scanner sc = new Scanner(System.in);
            String[] args = sc.nextLine().split("\\s", 0);
            double x = Float.parseFloat(args[0]);
            double y = Float.parseFloat(args[1]);
            System.out.println("Result: " + Rosenbrock2d(x, y));
        }
    }

    private double Rosenbrock2d(double x, double y) {
        return 100 * Math.pow((Math.pow(x, 2) - y), 2) + Math.pow((x - 1), 2);
    }
}
