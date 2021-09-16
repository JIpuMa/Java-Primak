package com.company.Hw;

import java.util.Scanner;

public class t_01_02_03 {
    public void main() {
        System.out.print("Перше число: ");
        Scanner scan1 = new Scanner(System.in);
        double num1 = scan1.nextFloat();
        System.out.print("Друге число: ");
        Scanner scan2 = new Scanner(System.in);
        double num2 = scan2.nextFloat();
        double geom_mean = Math.sqrt(num1 * num2);
        System.out.println("Середнє геометричне в:");
        System.out.printf("\t-науковому представленні: %s\n", geom_mean);
        System.out.printf("\t-десятковому представленні: %e\n", geom_mean);
    }
}
