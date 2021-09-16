package com.company.Cw;

import java.util.Scanner;

public class t_01_03_09 {
    public void main(){
        System.out.print("n1 = ");
        Scanner sc1 = new Scanner(System.in);
        double num1 = sc1.nextDouble();
        System.out.print("n2 = ");
        Scanner sc2 = new Scanner(System.in);
        double num2 = sc2.nextDouble();
        double dif = num1 - num2;
        double mul = num1 * num2;
        System.out.printf("Difference: %.2f\n", dif);
        System.out.printf("Multiplication: %.4f\n", mul);
    }
}
