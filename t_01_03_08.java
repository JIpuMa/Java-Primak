package com.company.Cw;

import java.util.Scanner;

public class t_01_03_08 {
    public void main() {
        System.out.print("x = ");
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int int_x, max_x, min_x, round_x;
        double fract_x;
        if (x > 0) {
            int_x = (int) x;
            min_x = (int) x;
            max_x = min_x + 1;
            fract_x = x - min_x;
            round_x = (fract_x >= 0.5) ? max_x : min_x;
        } else {
            int_x = (int) x - 1;
            max_x = (int) x;
            min_x = max_x - 1;
            fract_x = x - min_x;
            round_x = (fract_x >= 0.5) ? max_x : min_x;
        }
        System.out.println("Ціла частина: " + int_x);
        System.out.println("Дробова частина: " + fract_x);

        System.out.println("Без математичних функцій:");
        System.out.println("\tНайбільше ціле, що менше за х: " + min_x);
        System.out.println("\tНайменше ціле, що більше за х: " + max_x);
        System.out.println("\tОкруглене число: " + round_x);

        System.out.println("З математичними функціями:");
        System.out.println("\tНайбільше ціле, що менше за х: " + Math.floor(x));
        System.out.println("\tНайменше ціле, що більше за х: " + Math.ceil(x));
        System.out.println("\tОкруглене число: " + Math.round(x));
    }
}
